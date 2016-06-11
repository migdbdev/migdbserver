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

import org.migdb.migdbserver.main.neuralnetwork.NetworkConfiguration;

public class DataSetUpdateRequestMessage {

	private String requestId;
	private int columnCount;
	private int numericCount;
	private int stringCount;
	private int calenderCount;
	private String mappingModel;
	private double modelvalue;

	public double getModelvalue() {
		return modelvalue;
	}

	public void setModelvalue(double modelvalue) {
		this.modelvalue = modelvalue;
	}

	public DataSetUpdateRequestMessage() {

	}

	public boolean validateDataSetUpdateRequestMessage() {
		int errorCount = 0;

		NetworkConfiguration config = new NetworkConfiguration();
		if (this.getColumnCount() <= 0)
			errorCount++;
		if (this.getNumericCount() < 0)
			errorCount++;
		if (this.getStringCount() < 0)
			errorCount++;
		if (this.getCalenderCount() < 0)
			errorCount++;
		if (!this.getMappingModel().equalsIgnoreCase(config.getEMBEDDING_NAME())
				&& !this.getMappingModel().equalsIgnoreCase(config.getREFERENCING_NAME()))
			errorCount++;

		int countableColumn = this.getNumericCount() + this.getStringCount() + this.getCalenderCount();
		if (countableColumn > this.getColumnCount())
			errorCount++;

		if (errorCount > 0)
			return false;

		return true;
	}

	public String createRowValueText() {

		String text = String.valueOf((double) this.getColumnCount()) + ","
				+ String.valueOf((double) this.getNumericCount()) + "," + String.valueOf((double) this.getStringCount())
				+ "," + String.valueOf((double) this.getCalenderCount()) + ","
				+ String.valueOf((double) this.getModelvalue());
		System.out.println("update value row : " + text);
		return text;
	}

	public void setModelValueToParameter(NetworkConfiguration config) {

		if (this.getMappingModel().equalsIgnoreCase(config.getREFERENCING_NAME()))
			this.setModelvalue(config.getREFERENCING_VALUE());

		if (this.getMappingModel().equalsIgnoreCase(config.getEMBEDDING_NAME()))
			this.setModelvalue(config.getEMBEDDING_VALUE());

	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	public String getMappingModel() {
		return mappingModel;
	}

	public void setMappingModel(String mappingModel) {
		this.mappingModel = mappingModel;
	}

}
