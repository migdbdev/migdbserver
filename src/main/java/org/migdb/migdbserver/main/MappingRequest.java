package org.migdb.migdbserver.main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.migdb.migdbserver.main.resources.MappingRequestMessage;
import org.migdb.migdbserver.main.resources.MappingResponse;
import org.migdb.migdbserver.main.services.BuildResponse;
import org.migdb.migdbserver.main.services.MappingRequestValidator;
import org.migdb.migdbserver.main.services.NeuralNetworkAccess;


/**
 * @author Gayan 
 * @see Class to handle mapping requests from client application and expose functionality as a REST api.
 *
 */
@Path("/mappingrequest")
public class MappingRequest {

	/**
	 * @return server status;
	 */
	@GET
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response returnServerStatus(@Context UriInfo uriinfo) {
		String serverstatus = "SERVER IS ONLINE.SEND VALID REQUEST IN POST";
		return Response.status(Status.OK).header("Entrypoint", uriinfo.getAbsolutePath()).entity(serverstatus).build();

	}
	
	
	/**
	 * @return response message with mapping model
	 * @return error message with error code
	 * accept both application/json and application/xml
	 */
	@POST
	@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response retrunMappingResponse(MappingRequestMessage mappingrequest, @Context UriInfo uriinfo) {
		// validate client request for mapping model
		MappingRequestValidator mappingRequestValidator = new MappingRequestValidator(mappingrequest);
		mappingRequestValidator.validateMappingRequest();

		// access neural network and process parameters
		NeuralNetworkAccess neuralnetworkaccess = new NeuralNetworkAccess();

		// build response from the response returning from neural network
		BuildResponse buildresponse = new BuildResponse(neuralnetworkaccess.getNeuralResponse(mappingrequest));
		MappingResponse mappingresponse = buildresponse.getMappingResponse();

		// build final response message format and include extra data of status
		return Response.status(Status.OK).header("Entrypoint", uriinfo.getAbsolutePath()).entity(mappingresponse)
				.build();

	}

}
