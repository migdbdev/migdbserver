/*
 * Copyright (c) 2016, MigDB(http://www.migdb.org) All Rights Reserved.
 *
 * MigDB. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.migdb.migdbserver.main.services;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

import org.glassfish.jersey.internal.util.Base64;
import org.migdb.migdbserver.main.config.AuthenticationParameters;
import org.migdb.migdbserver.main.config.Documentation;
import org.migdb.migdbserver.main.config.ErrorCodes;
import org.migdb.migdbserver.main.resources.ErrorMessage;

/**
 * @author Gayan 
 * @description Basic Authentication validation class
 *
 */
@Provider
public class AuthorizationFilter implements ContainerRequestFilter {
	// client application identification id
	private String applicationId;
	// client application security key
	private String securityKey;


	/**
	 * @return applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}

	
	/**
	 * @param applicationId
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	
	/**
	 * @return securityKey
	 */
	public String getSecurityKey() {
		return securityKey;
	}

	
	/**
	 * @param securityKey
	 */
	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

	
	/* (non-Javadoc)
	 * @see javax.ws.rs.container.ContainerRequestFilter#filter(javax.ws.rs.container.ContainerRequestContext)
	 */
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// extract header values using key
		List<String> authHeader = requestContext.getHeaders().get(AuthenticationParameters.AUTHORIZATION_HEADER_KEY);
		// check is header Authentication parameter set or not
		if (authHeader != null && authHeader.size() > 0) {

			try {
				// extract applicationid and security key from header parameter
				String[] authParameters = AuthorizationFilter.decode(authHeader.get(0));
				this.setApplicationId(authParameters[0]);
				this.setSecurityKey(authParameters[1]);

			} catch (Exception ex) {
				// if element not found this exception throws
				String errorMessage = "NOT FOUND STANDARD APPLICATIONID OR SECURITYKEY";

				ErrorMessage errormessage = new ErrorMessage(ErrorCodes.UNAUTHORIZED_NO_HEADER_PARAM, errorMessage,
						Documentation.NO_AUTH_PARAM_ELEMENT_DOC);
				Response unauthorizedStatus = Response.status(Status.UNAUTHORIZED).entity(errormessage)
						.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY,
								AuthorizationFilter.HTTPBasicAuthFilter(AuthenticationParameters.SERVER_ID,
										AuthenticationParameters.SERVER_SECURITY_KEY))
						.build();
				requestContext.abortWith(unauthorizedStatus);
			}

			// validate applicationId and SecurityId according to predefined
			// context

			if (AuthenticationParameters.APPLICATION_ID.equals(applicationId)
					&& AuthenticationParameters.SECURITY_KEY.equals(securityKey)) {
				return;

			} else {
				// client did not provide valid credential.Error message return
				String errorMessage = "@APPLICATIONID:" + applicationId + " @SECURITYKEY:" + securityKey + " invalid";

				ErrorMessage errormessage = new ErrorMessage(ErrorCodes.UNAUTHORIZED_INVALID_HEADER_PARAM, errorMessage,
						Documentation.AUTH_PARAM_INVALID_DOC);
				Response unauthorizedStatus = Response.status(Status.UNAUTHORIZED).entity(errormessage)
						.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY,
								AuthorizationFilter.HTTPBasicAuthFilter(AuthenticationParameters.SERVER_ID,
										AuthenticationParameters.SERVER_SECURITY_KEY))
						.build();
				requestContext.abortWith(unauthorizedStatus);

			}

		} else {
			// client request do not provide any Authorization value
			String errorMessage = "NO APPLICATIONID AND SECURITYKEY PRESENTED";

			ErrorMessage errormessage = new ErrorMessage(ErrorCodes.UNAUTHORIZED_NO_HEADER_PARAM, errorMessage,
					Documentation.NO_AUTH_PARAM_PRESENTED_DOC);
			Response unauthorizedStatus = Response.status(Status.UNAUTHORIZED).entity(errormessage)
					.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
							AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
					.build();
			requestContext.abortWith(unauthorizedStatus);
		}

	}

	
	/**
	 * @param auth
	 * @return String[] userName and password
	 */
	public static String[] decode(String auth) {
		// Replacing "Basic THE_BASE_64" to "THE_BASE_64" directly
		auth = auth.replaceFirst("[B|b]asic ", "");

		// Decode the Base64 into byte[]
		byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);

		// If the decode fails in any case
		if (decodedBytes == null || decodedBytes.length == 0) {
			return null;
		}

		// convert the byte[] into a splitted array :
		// - the first one is login,
		// - the second one password
		return new String(decodedBytes).split(":", 2);
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 * @description Basic Authentication validation class
	 *
	 */
	public static String HTTPBasicAuthFilter(final String username, final String password) {

		String serverSignature = Base64.encodeAsString(username + ":" + password);
		serverSignature = AuthenticationParameters.AUTHORIZATION_HEADER_PREFIX + " " + serverSignature;
		return serverSignature;
	}

}
