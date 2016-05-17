package org.migdb.migdbserver.main.resources;

import org.migdb.migdbserver.main.neuralnetwork.NeuralNetwork;

public class NeuralResponse {
	
	private String responseId;
	private String mappingModel;
	private String collectionOrder;
	private String clientId;
	private String requestId;
	
	public NeuralResponse(){
		
	}
	
	public NeuralResponse(NeuralNetwork neuralnetwork){
		this.requestId = neuralnetwork.getRequestId();
		this.clientId = neuralnetwork.getClientId();
		this.collectionOrder = neuralnetwork.getCollectionOrder();
		this.mappingModel = neuralnetwork.getMappingModel();
		this.responseId = neuralnetwork.getResponseId();
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
