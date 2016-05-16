package org.migdb.migdbserver.main;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.migdb.migdbserver.main.resources.MappingResponse;
import org.migdb.migdbserver.main.services.BuildResponse;
import org.migdb.migdbserver.main.services.NeuralNetworkAccess;

/**
 * @author Gayan
 *
 */
@Path("/mappingrequest")
public class MappingRequest {
	
	
	/**
	 * @return server status;
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String returnServerStatus(){
		
		return "SERVER IS ONLINE.SEND VALID REQUEST IN POST";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_XML)
	public MappingResponse retrunMappingResponse(){
		NeuralNetworkAccess neuralnetworkaccess = new NeuralNetworkAccess();
		BuildResponse buildresponse = new BuildResponse(neuralnetworkaccess.getNeuralResponse("request123"));
		return buildresponse.getMappingResponse();
	}

}
