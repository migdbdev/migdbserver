package org.migdb.migdbserver.main.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.migdb.migdbserver.main.config.ErrorCodes;
import org.migdb.migdbserver.main.resources.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errormessage = new ErrorMessage(ErrorCodes.GENERIC_ERROR,exception.getMessage(), "path to documentation");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(errormessage).build();
	}
	
	 

}