/*
 * Copyright (c) 2016, MigDB(http://www.migdb.org) All Rights Reserved.
 *
 * MigDB. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.migdb.migdbserver.main.services;

import org.migdb.migdbserver.main.neuralnetwork.NeuralNetwork;
import org.migdb.migdbserver.main.resources.MappingRequestMessage;
import org.migdb.migdbserver.main.resources.NeuralResponse;

/**
 * @author Gayan
 * @description class to establish connection with neural network
 */

public class NeuralNetworkAccess {
	
	public NeuralNetworkAccess(){
		
	}

	/**
	 * @param mappingrequest
	 * @return NeuralResponse neural response message object
	 */
	public NeuralResponse getNeuralResponse(MappingRequestMessage mappingrequest) {
		// access neural network process and extract response
		NeuralNetwork neuralnetwork = new NeuralNetwork(mappingrequest);

		NeuralResponse neuralresponse = new NeuralResponse(neuralnetwork.getNeuralNetwork());
		return neuralresponse;
	}

}
