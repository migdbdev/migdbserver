package org.migdb.migdbserver.main.neuralnetwork;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class UpdateNetwork {

	NetworkConfiguration config = new NetworkConfiguration();

	// method to initiate fresh neural network and start learning network
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

	// method to read current data set and print data set on console
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

	// method to update data set csv file with new value row
	public boolean appendLineToDataSet(String filename, String rowValues) {

		try {
			CSVWriter writer = new CSVWriter(new FileWriter(filename, true), CSVWriter.DEFAULT_SEPARATOR,
					CSVWriter.NO_QUOTE_CHARACTER);
			String[] values = rowValues.split(",");
			writer.writeNext(values);
			writer.close();
			return true;
		} catch (IOException e) {

			System.err.println(e.getMessage());
			return false;
		}

	}

	public static void main(String arg[]) {
		NetworkConfiguration config1 = new NetworkConfiguration();
		UpdateNetwork update = new UpdateNetwork();

		update.appendLineToDataSet(config1.getTableInfoFilePath(), null);

		update.readAndPrintDataSet(config1.getTableInfoFilePath());
	}

}
