package org.migdb.migdbserver.main.services;

import org.migdb.migdbserver.main.resources.NeuralResponse;

public class NeuralNetworkAccess {
	
	public NeuralResponse getNeuralResponse(String requestId){
		//access neural network process and extract response
		//generate temporary response coming from neural network
		NeuralResponse neuralresponse = new NeuralResponse(requestId);
		return neuralresponse; 
	}

}
