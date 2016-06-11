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

public class MappingRequestMessage {
	// designed temporary upto 121 and 12M relationships
	private String clientId;
	private String requestId;
	private String authorizationKey;
	private String relationshipType;

	private int columnCount;
	private int numericCount;
	private int stringCount;
	private int calenderCount;

	public MappingRequestMessage(String clientId, String requestId, String authorizationKey, String relationshipType,
			int columnCount, int numericCount, int stringCount, int calenderCount) {
		this.clientId = clientId;
		this.requestId = requestId;
		this.authorizationKey = authorizationKey;
		this.relationshipType = relationshipType;
		this.columnCount = columnCount;
		this.numericCount = numericCount;
		this.stringCount = stringCount;
		this.calenderCount = calenderCount;

	}

	public MappingRequestMessage() {

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

	public String getAuthorizationKey() {
		return authorizationKey;
	}

	public void setAuthorizationKey(String authorizationKey) {
		this.authorizationKey = authorizationKey;
	}

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public int getNumericCount() {
		return numericCount;
	}

	public void setNumericCount(int numericCount) {
		this.numericCount = numericCount;
	}

	public int getStringCount() {
		return stringCount;
	}

	public void setStringCount(int stringCount) {
		this.stringCount = stringCount;
	}

	public int getCalenderCount() {
		return calenderCount;
	}

	public void setCalenderCount(int calenderCount) {
		this.calenderCount = calenderCount;
	}

	public double[] convertParamToArray() {
		double[] paramArray = { Double.valueOf(this.getColumnCount()), Double.valueOf(this.getNumericCount()),
				Double.valueOf(this.getStringCount()), Double.valueOf(this.getCalenderCount()) };
		return paramArray;

	}

}
