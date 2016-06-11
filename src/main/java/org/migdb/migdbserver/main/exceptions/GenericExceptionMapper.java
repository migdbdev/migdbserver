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
package org.migdb.migdbserver.main.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.migdb.migdbserver.main.config.AuthenticationParameters;
import org.migdb.migdbserver.main.config.ErrorCodes;
import org.migdb.migdbserver.main.resources.ErrorMessage;
import org.migdb.migdbserver.main.services.AuthorizationFilter;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errormessage = new ErrorMessage(ErrorCodes.GENERIC_ERROR, exception.getMessage(),
				"path to documentation");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errormessage)
				.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
						AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
				.build();
	}

}