package org.migdb.migdbserver.main.neuralnetwork;

import org.migdb.migdbserver.main.resources.MappingRequestMessage;

public class NeuralNetwork {
	private String responseId = "res745867498";
	private String mappingModel = "EMBEDDING";
	private String collectionOrder = "L2R";
	private String clientId;
	private String requestId;
	
	public NeuralNetwork(){
		
	}
	
	public NeuralNetwork(MappingRequestMessage mappingrequestmessage){
	this.clientId = mappingrequestmessage.getClientId();
	this.requestId = mappingrequestmessage.getRequestId();
	}
	
	public NeuralNetwork getNeuralNetwork(){
		return this;
		
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
	
	

}