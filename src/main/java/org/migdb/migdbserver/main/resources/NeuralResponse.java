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
package org.migdb.migdbserver.main.resources;

import org.migdb.migdbserver.main.neuralnetwork.NeuralNetwork;

/**
 * @author Gayan
 * @description Template class for mapping response message coming from neural network
 */
public class NeuralResponse {

	
	private String mappingModel;
	private String complexity;
	private String clientId;
	private String requestId;
	private String moreInformation;
	

	/**
	 * @return moreInformation
	 */
	public String getMoreInformation() {
		return moreInformation;
	}

	/**
	 * @param moreInformation
	 */
	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	/**
	 * Default constructor
	 */
	public NeuralResponse() {

	}

	/**
	 * @param neuralnetwork
	 * @description constructor
	 */
	public NeuralResponse(NeuralNetwork neuralnetwork) {
		this.requestId = neuralnetwork.getRequestId();
		this.clientId = neuralnetwork.getClientId();
		this.complexity = neuralnetwork.getComplexity();
		this.mappingModel = neuralnetwork.getMappingModel();
		this.moreInformation = neuralnetwork.getMoreInformation();
	}

	/**
	 * @return requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}



	/**
	 * @return mappingModel
	 */
	public String getMappingModel() {
		return mappingModel;
	}

	/**
	 * @param mappingModel
	 */
	public void setMappingModel(String mappingModel) {
		this.mappingModel = mappingModel;
	}

	/**
	 * @return complexity
	 */
	public String getComplexity() {
		return complexity;
	}

	/**
	 * @param collectionOrder
	 */
	public void setCollectionOrder(String collectionOrder) {
		this.complexity = collectionOrder;
	}

}
