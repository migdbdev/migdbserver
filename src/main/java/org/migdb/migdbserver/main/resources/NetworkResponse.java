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

import org.migdb.migdbserver.main.config.AuthenticationParameters;

/**
 * @author Gayan
 * @description Template class for the response coming from neural network update status
 *
 */
public class NetworkResponse {

	private String responseId;
	private String clientId;
	private String requestId;
	private Date createdTime;
	private String message;
	private int networkUpdated;
	private int rowInserted;
	private int affectedRows;

	/**
	 * Default constructor
	 */
	public NetworkResponse() {
		this.affectedRows = 0;
		this.clientId = AuthenticationParameters.APPLICATION_ID;
		this.createdTime = new Date();
		this.networkUpdated = 0;
		this.rowInserted = 0;
		this.affectedRows = 0;
		this.responseId = "UPD6395034539549";

	}

	/**
	 * @param message
	 * @param isNetworkUpdate
	 * @param isrowInserted
	 * @param noRows
	 * @description method to build response message with the action of neural network
	 */
	public void setResponseParameters(String message, boolean isNetworkUpdate,
			boolean isrowInserted, int noRows) {

		this.message = message;
		this.affectedRows = noRows;
		if (isNetworkUpdate)
			this.networkUpdated = 1;

		if (isrowInserted)
			this.rowInserted = 1;

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
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return networkUpdated
	 */
	public int getNetworkUpdated() {
		return networkUpdated;
	}

	/**
	 * @param networkUpdated
	 */
	public void setNetworkUpdated(int networkUpdated) {
		this.networkUpdated = networkUpdated;
	}

	/**
	 * @return rowInserted
	 */
	public int getRowInserted() {
		return rowInserted;
	}

	/**
	 * @param rowInserted
	 */
	public void setRowInserted(int rowInserted) {
		this.rowInserted = rowInserted;
	}

	/**
	 * @return affectedRows
	 */
	public int getAffectedRows() {
		return affectedRows;
	}

	/**
	 * @param affectedRows
	 */
	public void setAffectedRows(int affectedRows) {
		this.affectedRows = affectedRows;
	}

}
