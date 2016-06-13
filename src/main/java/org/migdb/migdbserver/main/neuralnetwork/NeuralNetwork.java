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

/**
 * @author Gayan
 *@description Class to access neural network core functionalities 
 */
public class NeuralNetwork {
	private String responseId = "RES745867498";
	private String mappingModel;
	private String complexity;
	private String clientId;
	private String requestId;
	private String moreInformation;
	private double complexityValue = 0.0;

	/**
	 * @return
	 */
	public double getComplexityValue() {
		return complexityValue;
	}

	/**
	 * @param complexityValue
	 */
	public void setComplexityValue(double complexityValue) {
		this.complexityValue = complexityValue;
	}

	/**
	 * @return
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
	 * Default Constructor
	 */
	public NeuralNetwork() {

	}

	/**
	 * @param mappingrequestmessage
	 * @description preparing neural network response parameters
	 */
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
				+ " CALENDER_COUNT = " + mappingrequestmessage.getCalenderCount();
		this.complexity = String.valueOf(this.complexityValue);
	}

	/**
	 * @return NeuralNetwork network instance
	 */
	public NeuralNetwork getNeuralNetwork() {
		return this;

	}

	/**
	 * @return
	 */
	public String getResponseId() {
		return responseId;
	}

	/**
	 * @param responseId
	 */
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	/**
	 * @return
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
	 * @return
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

	/**
	 * @return
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
	 * @return
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

}
