package org.migdb.migdbserver.main.services;

import org.migdb.migdbserver.main.neuralnetwork.NeuralNetwork;
import org.migdb.migdbserver.main.resources.MappingRequestMessage;
import org.migdb.migdbserver.main.resources.NeuralResponse;

public class NeuralNetworkAccess {
	
	public NeuralResponse getNeuralResponse(MappingRequestMessage mappingrequest){
		//access neural network process and extract response
		NeuralNetwork neuralnetwork = new NeuralNetwork(mappingrequest);
		
		NeuralResponse neuralresponse = new NeuralResponse(neuralnetwork.getNeuralNetwork());
		return neuralresponse; 
	}

}
