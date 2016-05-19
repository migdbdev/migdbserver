package org.migdb.migdbserver.main.services;
import org.migdb.migdbserver.main.resources.MappingResponse;
import org.migdb.migdbserver.main.resources.NeuralResponse;;


public class BuildResponse {
	
	private String responseId;
	private String clientId;
	private String requestId;
	private String mappingModel;
	private String moreInformation;
	
	
	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getMappingModel() {
		return mappingModel;
	}

	public void setMappingModel(String mappingModel) {
		this.mappingModel = mappingModel;
	}

	public BuildResponse(NeuralResponse neuralresponse){
		
		this.requestId = neuralresponse.getResponseId();
		this.clientId = neuralresponse.getClientId();
		this.requestId = neuralresponse.getRequestId();
		this.mappingModel = neuralresponse.getMappingModel();
		this.moreInformation = neuralresponse.getMoreInformation();
		
	}
	
	public MappingResponse getMappingResponse(){
		
		MappingResponse mappingresponse = new MappingResponse(this.responseId,this.clientId,this.requestId,this.mappingModel,this.moreInformation);
		return mappingresponse;
		
	}

}
