/**
 * Copyright 2013 Neuroph Project http://neuroph.sourceforge.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.migdb.migdbserver.main.neuralnetwork;

public class NetworkConfiguration {

	// File name where is saved main data set
	private String tableInfoFilePath;
	// File name where we will save training data set
	private String trainingFileName;
	// File name where we will save test data set
	private String testFileName;
	// File name where we will save balanced data set (3000 of
	// every type of tree created from training file)
	private String balancedFileName;
	// File name where we will save normalized balanced data set
	private String normalizedBalancedFileName;
	// File name where we will save trained neural network
	private String trainedNetworkFile;

	private String emptyNetworkFile;

	private final double EMBEDDING_VALUE = 0.0;

	private final double REFERENCING_VALUE = 1.0;

	private final double MIDDLE_VALUE = 0.5;

	public double getMIDDLE_VALUE() {
		return MIDDLE_VALUE;
	}

	private final String EMBEDDING_NAME = "EMBEDDING";

	private final String REFERENCING_NAME = "REFERENCING";

	private final String UNABLE_TO_PREDICT_NAME = "UNABLETOPREDICT";

	private int inputCount;

	private int MAX_TABLE_WEIGHT = 256;

	private final int COLUMN_WEIGHT = 2;

	private final int NUMERIC_WEIGHT = 5;

	private final int STRING_WEIGHT = 15;

	private final int CALENDER_WEIGHT = 10;

	public int getCOLUMN_WEIGHT() {
		return COLUMN_WEIGHT;
	}

	public int getNUMERIC_WEIGHT() {
		return NUMERIC_WEIGHT;
	}

	public int getSTRING_WEIGHT() {
		return STRING_WEIGHT;
	}

	public int getCALENDER_WEIGHT() {
		return CALENDER_WEIGHT;
	}

	public int getMAX_TABLE_WEIGHT() {
		return MAX_TABLE_WEIGHT;
	}

	public void setMAX_TABLE_WEIGHT(int mAX_TABLE_WEIGHT) {
		MAX_TABLE_WEIGHT = mAX_TABLE_WEIGHT;
	}

	public String getUNABLE_TO_PREDICT_NAME() {
		return UNABLE_TO_PREDICT_NAME;
	}

	public String getEMBEDDING_NAME() {
		return EMBEDDING_NAME;
	}

	public String getREFERENCING_NAME() {
		return REFERENCING_NAME;
	}

	private int firstHiddenLayerCount;
	private int secondHiddenLayerCount;

	public double getEMBEDDING_VALUE() {
		return EMBEDDING_VALUE;
	}

	public double getREFERENCING_VALUE() {
		return REFERENCING_VALUE;
	}

	private int outputCount;

	public String getEmptyNetworkFile() {
		return emptyNetworkFile;
	}

	public void setEmptyNetworkFile(String emptyNetworkFile) {
		this.emptyNetworkFile = emptyNetworkFile;
	}

	private String delimeter;

	public String getDelimeter() {
		return delimeter;
	}

	public void setDelimeter(String delimeter) {
		this.delimeter = delimeter;
	}

	public NetworkConfiguration() {

		tableInfoFilePath = "/\\GAYANPC/webapps/networks/learningset/tableinfo.txt";
		trainedNetworkFile = "/\\GAYANPC/webapps/networks/datainspector/trainedNetwork.txt";
		emptyNetworkFile = "/\\GAYANPC/webapps/networks/datainspector/emptyNetwork.txt";
		delimeter = ",";

		inputCount = 4;
		outputCount = 1;
		firstHiddenLayerCount = 16;
		secondHiddenLayerCount = 10;

	}

	public String getTableInfoFilePath() {
		return tableInfoFilePath;
	}

	public void setDataFilePath(String dataFilePath) {
		this.tableInfoFilePath = dataFilePath;
	}

	public String getTrainingFileName() {
		return trainingFileName;
	}

	public void setTrainingFileName(String trainingFileName) {
		this.trainingFileName = trainingFileName;
	}

	public String getTestFileName() {
		return testFileName;
	}

	public void setTestFileName(String testFileName) {
		this.testFileName = testFileName;
	}

	public String getBalancedFileName() {
		return balancedFileName;
	}

	public void setBalancedFileName(String balancedFileName) {
		this.balancedFileName = balancedFileName;
	}

	public String getNormalizedBalancedFileName() {
		return normalizedBalancedFileName;
	}

	public void setNormalizedBalancedFileName(String normalizedBalanceFileName) {
		this.normalizedBalancedFileName = normalizedBalanceFileName;
	}

	public String getTrainedNetworkFileName() {
		return trainedNetworkFile;
	}

	public void setTrainedNetworkFileName(String trainedNetworkFileName) {
		this.trainedNetworkFile = trainedNetworkFileName;
	}

	public int getInputCount() {
		return inputCount;
	}

	public void setInputCount(int inputCount) {
		this.inputCount = inputCount;
	}

	public int getFirstHiddenLayerCount() {
		return firstHiddenLayerCount;
	}

	public void setFirstHiddenLayerCount(int firstHiddenLayerCount) {
		this.firstHiddenLayerCount = firstHiddenLayerCount;
	}

	public int getSecondHiddenLayerCount() {
		return secondHiddenLayerCount;
	}

	public void setSecondHiddenLayerCount(int secondHiddenLayerCount) {
		this.secondHiddenLayerCount = secondHiddenLayerCount;
	}

	public int getOutputCount() {
		return outputCount;
	}

	public void setOutputCount(int outputCount) {
		this.outputCount = outputCount;
	}
}
