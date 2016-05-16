package org.migdb.migdbserver.main.services;
import org.migdb.migdbserver.main.resources.MappingResponse;
import org.migdb.migdbserver.main.resources.NeuralResponse;;


public class BuildResponse {
	
	String responseId;
	String clientId;
	String requestId;
	String mappingModel;
	
	
	public BuildResponse(NeuralResponse neuralresponse){
		
		this.requestId = neuralresponse.getResponseId();
		this.clientId = neuralresponse.getClientId();
		this.requestId = neuralresponse.getRequestId();
		this.mappingModel = neuralresponse.getMappingModel();
		
	}
	
	public MappingResponse getMappingResponse(){
		
		MappingResponse mappingresponse = new MappingResponse(this.responseId,this.clientId,this.requestId,this.mappingModel);
		return mappingresponse;
		
	}

}
