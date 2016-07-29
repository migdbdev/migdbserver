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
package org.migdb.migdbserver.main.neuralnetwork;

/**
 * @author Gayan
 * @description Class for neural network configuration parameters
 *
 */
public class NetworkConfiguration {

	
	private String tableInfoFilePath;
	
	private String trainingFileName;
	
	private String testFileName;
	
	private String trainedNetworkFile;

	private String emptyNetworkFile;

	private final double EMBEDDING_VALUE = 0.0;

	private final double REFERENCING_VALUE = 1.0;

	private final double MIDDLE_VALUE = 0.5;

	private final String EMBEDDING_NAME = "EMBEDDING";

	private final String REFERENCING_NAME = "REFERENCING";

	private final String UNABLE_TO_PREDICT_NAME = "UNABLETOPREDICT";

	private int inputCount;

	private int MAX_TABLE_WEIGHT = 256;

	private final int COLUMN_WEIGHT = 2;

	private final int NUMERIC_WEIGHT = 5;

	private final int STRING_WEIGHT = 15;

	private final int CALENDER_WEIGHT = 10;
	
	private int firstHiddenLayerCount;
	
	private int secondHiddenLayerCount;
	
	private int outputCount;
	
	private String delimeter;
	
	private static String COLLECTION_STRUCTURE_FORMAT = "json";
	
	public String getTrainedNetworkFile() {
		return trainedNetworkFile;
	}

	public void setTrainedNetworkFile(String trainedNetworkFile) {
		this.trainedNetworkFile = trainedNetworkFile;
	}

	public String getCOLLECTION_STRUCTURE_FORMAT() {
		return COLLECTION_STRUCTURE_FORMAT;
	}

	public void setCOLLECTION_STRUCTURE_FORMAT(String cOLLECTION_STRUCTURE_FORMAT) {
		COLLECTION_STRUCTURE_FORMAT = cOLLECTION_STRUCTURE_FORMAT;
	}

	public void setTableInfoFilePath(String tableInfoFilePath) {
		this.tableInfoFilePath = tableInfoFilePath;
	}

	/**
	 * @return
	 */
	public double getMIDDLE_VALUE() {
		return MIDDLE_VALUE;
	}

	/**
	 * @return
	 */
	public int getCOLUMN_WEIGHT() {
		return COLUMN_WEIGHT;
	}

	/**
	 * @return
	 */
	public int getNUMERIC_WEIGHT() {
		return NUMERIC_WEIGHT;
	}

	/**
	 * @return
	 */
	public int getSTRING_WEIGHT() {
		return STRING_WEIGHT;
	}

	/**
	 * @return
	 */
	public int getCALENDER_WEIGHT() {
		return CALENDER_WEIGHT;
	}

	/**
	 * @return
	 */
	public int getMAX_TABLE_WEIGHT() {
		return MAX_TABLE_WEIGHT;
	}

	/**
	 * @param mAX_TABLE_WEIGHT
	 */
	public void setMAX_TABLE_WEIGHT(int mAX_TABLE_WEIGHT) {
		MAX_TABLE_WEIGHT = mAX_TABLE_WEIGHT;
	}

	/**
	 * @return
	 */
	public String getUNABLE_TO_PREDICT_NAME() {
		return UNABLE_TO_PREDICT_NAME;
	}

	/**
	 * @return
	 */
	public String getEMBEDDING_NAME() {
		return EMBEDDING_NAME;
	}

	/**
	 * @return
	 */
	public String getREFERENCING_NAME() {
		return REFERENCING_NAME;
	}

	
	/**
	 * @return
	 */
	public double getEMBEDDING_VALUE() {
		return EMBEDDING_VALUE;
	}

	/**
	 * @return
	 */
	public double getREFERENCING_VALUE() {
		return REFERENCING_VALUE;
	}

	public String getEmptyNetworkFile() {
		return emptyNetworkFile;
	}

	public void setEmptyNetworkFile(String emptyNetworkFile) {
		this.emptyNetworkFile = emptyNetworkFile;
	}

	/**
	 * @return
	 */
	public String getDelimeter() {
		return delimeter;
	}

	/**
	 * @param delimeter
	 */
	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}

	/**
	 * @return
	 */
	public String getTableInfoFilePath() {
		return tableInfoFilePath;
	}

	/**
	 * @param dataFilePath
	 */
	public void setDataFilePath(String dataFilePath) {
		this.tableInfoFilePath = dataFilePath;
	}

	/**
	 * @return
	 */
	public String getTrainingFileName() {
		return trainingFileName;
	}

	/**
	 * @param trainingFileName
	 */
	public void setTrainingFileName(String trainingFileName) {
		this.trainingFileName = trainingFileName;
	}

	/**
	 * @return
	 */
	public String getTestFileName() {
		return testFileName;
	}

	/**
	 * @param testFileName
	 */
	public void setTestFileName(String testFileName) {
		this.testFileName = testFileName;
	}

	
	/**
	 * @return
	 */
	public String getTrainedNetworkFileName() {
		return trainedNetworkFile;
	}

	/**
	 * @param trainedNetworkFileName
	 */
	public void setTrainedNetworkFileName(String trainedNetworkFileName) {
		this.trainedNetworkFile = trainedNetworkFileName;
	}

	/**
	 * @return
	 */
	public int getInputCount() {
		return inputCount;
	}

	/**
	 * @param inputCount
	 */
	public void setInputCount(int inputCount) {
		this.inputCount = inputCount;
	}

	/**
	 * @return
	 */
	public int getFirstHiddenLayerCount() {
		return firstHiddenLayerCount;
	}

	/**
	 * @param firstHiddenLayerCount
	 */
	public void setFirstHiddenLayerCount(int firstHiddenLayerCount) {
		this.firstHiddenLayerCount = firstHiddenLayerCount;
	}

	/**
	 * @return
	 */
	public int getSecondHiddenLayerCount() {
		return secondHiddenLayerCount;
	}

	/**
	 * @param secondHiddenLayerCount
	 */
	public void setSecondHiddenLayerCount(int secondHiddenLayerCount) {
		this.secondHiddenLayerCount = secondHiddenLayerCount;
	}

	/**
	 * @return
	 */
	public int getOutputCount() {
		return outputCount;
	}

	/**
	 * @param outputCount
	 */
	public void setOutputCount(int outputCount) {
		this.outputCount = outputCount;
	}
	
	/**
	 * Constructor
	 */
	public NetworkConfiguration() {

		tableInfoFilePath = FilePath.DOCUMENT.getPath() + FilePath.TRAININGSET.getPath();
		trainedNetworkFile = FilePath.DOCUMENT.getPath() + FilePath.TRAINEDNETWORK.getPath();
		emptyNetworkFile = FilePath.DOCUMENT.getPath() + FilePath.EMPTYNETWORK.getPath();
		delimeter = ",";
		inputCount = 4;
		outputCount = 1;
		firstHiddenLayerCount = 16;
		secondHiddenLayerCount = 10;

	}
}
