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