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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;

import au.com.bytecode.opencsv.CSVReader;


/**
 * @author Gayan
 * @description class to train to change training data set
 *
 */
public class UpdateNetwork {

	NetworkConfiguration config = new NetworkConfiguration();

	
	/**
	 * @param core
	 * @param config
	 * @return Boolean state of neural network
	 * @description method to initiate fresh neural network and start learning network
	 */
	public boolean updateNetworkStatus(NeuralNetworkCore core, NetworkConfiguration config) {

		core = new NeuralNetworkCore();
		try {
			core.createNetwork(config);
			core.trainNetwork(config);
			return true;
		} catch (Exception ex) {
			System.out.println("Server update Exception:" + ex);
			return false;
		}

	}

	
	/**
	 * @param filename
	 * @description method to read current data set and print data set on console
	 */
	public void readAndPrintDataSet(String filename) {

		CSVReader reader;
		try {
			reader = new CSVReader(new FileReader(filename));
			String[] row;
			System.out.println("---Mapping Model Data Set---");
			System.out.println(" ");
			while ((row = reader.readNext()) != null) {
				for (int i = 0; i < row.length; i++) {
					// display CSV values
					System.out.print(row[i] + " ");
					if (i == row.length - 1) {
						System.out.println(" ");
					}

				}
			}
			System.out.println("");
			System.out.println("---End of Data Set---");
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	
	/**
	 * @param filename
	 * @param rowValues
	 * @return Boolean
	 * @description  method to update data set csv file with new value row
	 */
	public boolean appendLineToDataSet(String filename, String rowValues) {

		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(filename, true), ',');
			String[] values = rowValues.split(",");
			csvOutput.writeRecord(values);
			csvOutput.close();
			return true;
		} catch (IOException e) {

			System.err.println(e.getMessage());
			return false;
		}

	}

}
