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

import org.migdb.migdbserver.main.resources.MappingResponse;
import org.migdb.migdbserver.main.resources.NeuralResponse;;

/**
 * @author Gayan
 * @description Class to build response message
 *
 */
public class BuildResponse {

	private String responseId;
	private String clientId;
	private String requestId;
	private String mappingModel;
	private String moreInformation;
	private String complexity;

	/**
	 * @return complexity
	 */
	public String getComplexity() {
		return complexity;
	}

	/**
	 * @param complexity
	 */
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

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
	 * @return responseId
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
	 * @param neuralresponse
	 * @description constructor
	 */
	public BuildResponse(NeuralResponse neuralresponse) {

		this.requestId = neuralresponse.getResponseId();
		this.clientId = neuralresponse.getClientId();
		this.requestId = neuralresponse.getRequestId();
		this.mappingModel = neuralresponse.getMappingModel();
		this.moreInformation = neuralresponse.getMoreInformation();
		this.complexity = neuralresponse.getComplexity();

	}

	/**
	 * @return MappingResponse
	 * @description Method to return mapping response message
	 */
	public MappingResponse getMappingResponse() {

		MappingResponse mappingresponse = new MappingResponse(this.responseId, this.clientId, this.requestId,
				this.mappingModel, this.moreInformation, this.complexity);
		return mappingresponse;

	}

}
