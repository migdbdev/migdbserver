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
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.migdb.migdbserver.main.config.AuthenticationParameters;

/**
 * @author Gayan
 *@description Template Class of mapping response sending to client
 */
@XmlRootElement
public class MappingResponse {

	
	private String clientId;
	private String requestId;
	private Date createdTime;
	private Date expiryTime;
	private String mappingModel;
	private String complexity;
	private String moreInformation;
	private String response;
	

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @param responseId
	 * @param clientId
	 * @param requestId
	 * @param mappingModel
	 * @param moreInformation
	 * @param complexity
	 * @description Constructor
	 */
	public MappingResponse(String clientId, String requestId, String mappingModel,
			String moreInformation, String complexity) {
		
		this.clientId = clientId;
		this.requestId = requestId;
		this.createdTime = new Date();
		this.mappingModel = mappingModel;
		this.moreInformation = moreInformation;
		this.complexity = complexity;
		this.response = getNextUUID();
	}

	/**
	 * Default Constructor
	 */
	public MappingResponse() {

	}

	/**
	 * @param message
	 * @description Constructor
	 */
	public MappingResponse(String message) {
		this.createdTime = new Date();
		this.moreInformation = message;
		this.response = getNextUUID();
		this.clientId = AuthenticationParameters.APPLICATION_ID;
		this.requestId = "";
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
	 * @return createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return expiryTime
	 */
	public Date getExpiryTime() {
		return expiryTime;
	}

	/**
	 * @param expiryTime
	 */
	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
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
	 * @param complexity
	 */
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	/**
	 * @return moreInformation
	 */
	public String getMessageFromServer() {
		return moreInformation;
	}

	/**
	 * @param messageFromServer
	 */
	public void setMessageFromServer(String messageFromServer) {
		this.moreInformation = messageFromServer;
	}
	
	public static String getNextUUID() {
        return UUID.randomUUID().toString();
    }

}
