  package org.migdb.migdbserver.main.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.migdb.migdbserver.main.config.ErrorCodes;
import org.migdb.migdbserver.main.resources.ErrorMessage;

@Provider
public class RequestMessageParameterExceptionMapper implements ExceptionMapper<RequestMessageParameterException> {

	@Override
	public Response toResponse(RequestMessageParameterException exception) {
		ErrorMessage errormessage = new ErrorMessage(ErrorCodes.INVALID_PARAMETRS,exception.getMessage(), "path to documentation");
		return Response.status(Status.BAD_REQUEST).entity(errormessage).build();
	}
	
	 

}
 