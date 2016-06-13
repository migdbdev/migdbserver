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

/*
 * Definition of neural network parameters
 * ---------------------------------------
 * numericCount-->
 * 
 * */
package org.migdb.migdbserver.main.resources;

/**
 * Template class to hold request coming from client application
 * @author Gayan
 */
public class MappingRequestMessage {
	
	private String clientId;
	private String requestId;
	private int columnCount;
	private int numericCount;
	private int stringCount;
	private int calenderCount;

	public MappingRequestMessage(String clientId, String requestId,
			int columnCount, int numericCount, int stringCount, int calenderCount) {
		this.clientId = clientId;
		this.requestId = requestId;
	
		this.columnCount = columnCount;
		this.numericCount = numericCount;
		this.stringCount = stringCount;
		this.calenderCount = calenderCount;

	}

	/**
	 * Default Constructor
	 */
	public MappingRequestMessage() {

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
	 * @return columnCount
	 */
	public int getColumnCount() {
		return columnCount;
	}

	/**
	 * @param columnCount
	 */
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public int getNumericCount() {
		return numericCount;
	}

	/**
	 * @param numericCount
	 */
	public void setNumericCount(int numericCount) {
		this.numericCount = numericCount;
	}

	/**
	 * @return stringCount
	 */
	public int getStringCount() {
		return stringCount;
	}

	/**
	 * @param stringCount
	 */
	public void setStringCount(int stringCount) {
		this.stringCount = stringCount;
	}

	/**
	 * @return calenderCount
	 */
	public int getCalenderCount() {
		return calenderCount;
	}
	
	/**
	 * @param calenderCount
	 */
	public void setCalenderCount(int calenderCount) {
		this.calenderCount = calenderCount;
	}

	/**
     * Constructing the double array of input parameters to neural network
     * @param null
     * @return Double array
     * @throws null
     */
	public double[] convertParamToArray() {
		double[] paramArray = { Double.valueOf(this.getColumnCount()), Double.valueOf(this.getNumericCount()),
				Double.valueOf(this.getStringCount()), Double.valueOf(this.getCalenderCount()) };
		return paramArray;

	}

}
