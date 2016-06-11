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

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.migdb.migdbserver.main.config.AuthenticationParameters;

@XmlRootElement
public class MappingResponse {

	private String responseId;
	private String clientId;
	private String requestId;
	private Date createdTime;
	private Date expiryTime;
	private String mappingModel;
	private String collectionOrder;
	private String moreInformation;

	public MappingResponse(String responseId, String clientId, String requestId, String mappingModel,
			String moreInformation) {
		this.responseId = responseId;
		this.clientId = clientId;
		this.requestId = requestId;
		this.createdTime = new Date();
		this.mappingModel = mappingModel;
		this.moreInformation = moreInformation;
	}

	public MappingResponse() {

	}

	public MappingResponse(String message) {
		this.createdTime = new Date();
		this.moreInformation = message;
		this.responseId = "";
		this.clientId = AuthenticationParameters.APPLICATION_ID;
		this.requestId = "";
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
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

	public String getMessageFromServer() {
		return moreInformation;
	}

	public void setMessageFromServer(String messageFromServer) {
		this.moreInformation = messageFromServer;
	}

}
