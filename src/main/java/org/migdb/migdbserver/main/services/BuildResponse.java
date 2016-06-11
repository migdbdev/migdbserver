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

public class BuildResponse {

	private String responseId;
	private String clientId;
	private String requestId;
	private String mappingModel;
	private String moreInformation;
	private String complexity;

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
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

	public String getMappingModel() {
		return mappingModel;
	}

	public void setMappingModel(String mappingModel) {
		this.mappingModel = mappingModel;
	}

	public BuildResponse(NeuralResponse neuralresponse) {

		this.requestId = neuralresponse.getResponseId();
		this.clientId = neuralresponse.getClientId();
		this.requestId = neuralresponse.getRequestId();
		this.mappingModel = neuralresponse.getMappingModel();
		this.moreInformation = neuralresponse.getMoreInformation();
		this.complexity = neuralresponse.getComplexity();

	}

	public MappingResponse getMappingResponse() {

		MappingResponse mappingresponse = new MappingResponse(this.responseId, this.clientId, this.requestId,
				this.mappingModel, this.moreInformation, this.complexity);
		return mappingresponse;

	}

}
