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

public class NeuralResponse {

	private String responseId;
	private String mappingModel;
	private String collectionOrder;
	private String clientId;
	private String requestId;
	private String moreInformation;

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public NeuralResponse() {

	}

	public NeuralResponse(NeuralNetwork neuralnetwork) {
		this.requestId = neuralnetwork.getRequestId();
		this.clientId = neuralnetwork.getClientId();
		this.collectionOrder = neuralnetwork.getCollectionOrder();
		this.mappingModel = neuralnetwork.getMappingModel();
		this.responseId = neuralnetwork.getResponseId();
		this.moreInformation = neuralnetwork.getMoreInformation();
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
