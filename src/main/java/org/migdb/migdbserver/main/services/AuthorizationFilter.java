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

@Provider
public class AuthorizationFilter implements ContainerRequestFilter {

	private String applicationId;
	private String securityKey;

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getSecurityKey() {
		return securityKey;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// extract header values using key
		List<String> authHeader = requestContext.getHeaders().get(AuthenticationParameters.AUTHORIZATION_HEADER_KEY);
		// check is header Authentication parameter set or not
		if (authHeader != null && authHeader.size() > 0) {

			try {
				String[] authParameters = AuthorizationFilter.decode(authHeader.get(0));
				setApplicationId(authParameters[0]);
				setSecurityKey(authParameters[1]);

			} catch (Exception ex) {

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

			String errorMessage = "NO APPLICATIONID AND SECURITY_KEY PRESENTED";

			ErrorMessage errormessage = new ErrorMessage(ErrorCodes.UNAUTHORIZED_NO_HEADER_PARAM, errorMessage,
					Documentation.NO_AUTH_PARAM_PRESENTED_DOC);
			Response unauthorizedStatus = Response.status(Status.UNAUTHORIZED).entity(errormessage)
					.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
							AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
					.build();
			requestContext.abortWith(unauthorizedStatus);
		}

	}

	public static String[] decode(String auth) {
		// Replacing "Basic THE_BASE_64" to "THE_BASE_64" directly
		auth = auth.replaceFirst("[B|b]asic ", "");

		// Decode the Base64 into byte[]
		byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);

		// If the decode fails in any case
		if (decodedBytes == null || decodedBytes.length == 0) {
			return null;
		}

		// Now we can convert the byte[] into a splitted array :
		// - the first one is login,
		// - the second one password
		return new String(decodedBytes).split(":", 2);
	}

	public static String HTTPBasicAuthFilter(final String username, final String password) {
		String serverSignature = Base64.encodeAsString(username + ":" + password);
		serverSignature = "Basic " + serverSignature;
		return serverSignature;
	}

}
