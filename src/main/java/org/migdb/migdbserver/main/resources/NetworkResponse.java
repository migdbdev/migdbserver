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
