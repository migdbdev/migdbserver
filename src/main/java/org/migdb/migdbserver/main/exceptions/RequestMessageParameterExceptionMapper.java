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
public class RequestMessageParameterExceptionMapper implements ExceptionMapper<RequestMessageParameterException> {

	@Override
	public Response toResponse(RequestMessageParameterException exception) {
		ErrorMessage errormessage = new ErrorMessage(ErrorCodes.INVALID_PARAMETRS, exception.getMessage(),
				"path to documentation");
		return Response.status(Status.BAD_REQUEST).entity(errormessage)
				.header(AuthenticationParameters.AUTHORIZATION_HEADER_KEY, AuthorizationFilter.HTTPBasicAuthFilter(
						AuthenticationParameters.SERVER_ID, AuthenticationParameters.SERVER_SECURITY_KEY))
				.build();
	}

}