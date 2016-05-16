package org.migdb.migdbserver.main.resources;

public class NeuralResponse {
	
	private String responseId = "res745867498";
	private String mappingModel = "EMBEDDING";
	private String collectionOrder = "L2R";
	private String clientId = "cli75345693598";
	private String requestId;
	
	public NeuralResponse(){
		
	}
	
	public NeuralResponse(String requestID){
		this.requestId = requestID;
	}
	
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getResponseId() {
		return responseId;
	}
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}
	public String getMappingModel() {
		return mappingModel;
	}
	public void setMappingModel(String mappingModel) {
		this.mappingModel = mappingModel;
	}
	public String getCollectionOrder() {
		return collectionOrder;
	}
	public void setCollectionOrder(String collectionOrder) {
		this.collectionOrder = collectionOrder;
	}
	
	

}
