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

public class NetworkResponse {

	private String responseId;
	private String clientId;
	private String requestId;
	private Date createdTime;
	private String message;
	private int networkUpdated;
	private int rowInserted;
	private int affectedRows;

	public NetworkResponse() {
		this.affectedRows = 0;
		this.clientId = AuthenticationParameters.APPLICATION_ID;
		this.createdTime = new Date();
		this.networkUpdated = 0;
		this.rowInserted = 0;
		this.affectedRows = 0;
		this.responseId = "UPD6395034539549";

	}

	public void setResponseParameters(String message, boolean isNetworkUpdate, boolean isrowInserted, int noRows) {

		this.message = message;
		this.affectedRows = noRows;
		if (isNetworkUpdate)
			this.networkUpdated = 1;

		if (isrowInserted)
			this.rowInserted = 1;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getNetworkUpdated() {
		return networkUpdated;
	}

	public void setNetworkUpdated(int networkUpdated) {
		this.networkUpdated = networkUpdated;
	}

	public int getRowInserted() {
		return rowInserted;
	}

	public void setRowInserted(int rowInserted) {
		this.rowInserted = rowInserted;
	}

	public int getAffectedRows() {
		return affectedRows;
	}

	public void setAffectedRows(int affectedRows) {
		this.affectedRows = affectedRows;
	}

}
