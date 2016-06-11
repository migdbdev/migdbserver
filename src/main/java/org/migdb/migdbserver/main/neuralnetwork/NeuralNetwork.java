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
package org.migdb.migdbserver.main.neuralnetwork;

import org.migdb.migdbserver.main.resources.MappingRequestMessage;

public class NeuralNetwork {
	private String responseId = "res745867498";
	private String mappingModel = "";
	private String collectionOrder = "L2R";
	private String clientId;
	private String requestId;
	private String moreInformation;
	private double complexityValue = 0.0;

	public double getComplexityValue() {
		return complexityValue;
	}

	public void setComplexityValue(double complexityValue) {
		this.complexityValue = complexityValue;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public NeuralNetwork() {

	}

	public NeuralNetwork(MappingRequestMessage mappingrequestmessage) {

		this.clientId = mappingrequestmessage.getClientId();
		this.requestId = mappingrequestmessage.getRequestId();

		// Connect with neural network and process data and return output
		NetworkConfiguration config = new NetworkConfiguration();
		NeuralNetworkCore network = new NeuralNetworkCore();

		double input[] = mappingrequestmessage.convertParamToArray();
		double mappingmodel[] = network.getMappingModel(config, input);
		this.mappingModel = network.returnMappingModelName(config, mappingmodel[0]);

		TableComplexityEvaluator evaluator = new TableComplexityEvaluator();
		this.complexityValue = evaluator.getsumOfTableWeights(mappingrequestmessage);

		this.moreInformation = "COLUMN_COUNT = " + mappingrequestmessage.getColumnCount() + " NUMERIC_COUNT = "
				+ mappingrequestmessage.getNumericCount() + " STRING_COUNT = " + mappingrequestmessage.getStringCount()
				+ " CALENDER_COUNT = " + mappingrequestmessage.getCalenderCount() + " COMPLEXITY = "
				+ String.valueOf(complexityValue);

	}

	public NeuralNetwork getNeuralNetwork() {
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
