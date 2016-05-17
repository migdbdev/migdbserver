package org.migdb.migdbserver.main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.migdb.migdbserver.main.resources.MappingRequestMessage;
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
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MappingResponse retrunMappingResponse(MappingRequestMessage mappingrequest){
		NeuralNetworkAccess neuralnetworkaccess = new NeuralNetworkAccess();
		BuildResponse buildresponse = new BuildResponse(neuralnetworkaccess.getNeuralResponse(mappingrequest));
		return buildresponse.getMappingResponse();
	}

}
