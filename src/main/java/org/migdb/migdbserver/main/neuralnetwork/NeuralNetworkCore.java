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
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.Arrays;
import java.util.Date;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.core.events.LearningEventType;
import org.neuroph.core.exceptions.NeurophException;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TrainingSetImport;
import org.neuroph.util.TransferFunctionType;

/**
 * @author Gayan
 * @description class for neural network core functionality implementation
 *
 */
public class NeuralNetworkCore implements LearningEventListener {

	/**
	 * @param config
	 * @description create new neural network file and save on disk
	 */
	public void createNetwork(NetworkConfiguration config) {

		System.out.println("Creating neural network...");
		MultiLayerPerceptron neuralNet = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, config.getInputCount(),
				config.getFirstHiddenLayerCount(), config.getOutputCount());

		System.out.println("Neural network created!");

		// optimize neural network with learning parameters
		MomentumBackpropagation learningRule = (MomentumBackpropagation) neuralNet.getLearningRule();
		learningRule.setLearningRate(0.3);
		learningRule.setMomentum(0.7);
		learningRule.setMaxError(0.0001);
		learningRule.setMaxIterations(5000);

		// saving neural network in disk
		System.out.println("Saving neural network to file... ");
		neuralNet.save(config.getEmptyNetworkFile());
		System.out.println("Neural network successfully saved!");

	}

	/**
	 * @param config
	 * @description train created neural network using existing data set
	 * @throws  IOException , NumberFormatException , FileNotFoundException
	 */
	public void trainNetwork(NetworkConfiguration config) {

		DataSet trainingSet = null;
		try {
			trainingSet = TrainingSetImport.importFromFile(config.getTableInfoFilePath(), config.getInputCount(),
					config.getOutputCount(), config.getDelimeter());
		} catch (FileNotFoundException ex) {
			System.out.println("File not found!");
		} catch (IOException | NumberFormatException ex) {
			System.out.println("Error reading file or bad number format!");
		}
		// loading empty neural network
		MultiLayerPerceptron neuralNet1 = (MultiLayerPerceptron) NeuralNetwork
				.createFromFile(config.getEmptyNetworkFile());

		// learn the empty network using training set
		System.out.println("Training neural network...");
		MomentumBackpropagation learningRule = (MomentumBackpropagation) neuralNet1.getLearningRule();
		learningRule.addListener(this);
		neuralNet1.learn(trainingSet);
		System.out.println("Training successfully completed!");

		// save trained network on disk
		neuralNet1.save(config.getTrainedNetworkFileName());
		System.out.println("Trained network saved on disk!");
	}

	/* (non-Javadoc)
	 * @see org.neuroph.core.events.LearningEventListener#handleLearningEvent(org.neuroph.core.events.LearningEvent)
	 */
	@Override
	public void handleLearningEvent(LearningEvent event) {
		BackPropagation bp = (BackPropagation) event.getSource();
		if (event.getEventType().equals(LearningEventType.LEARNING_STOPPED)) {
			double error = bp.getTotalNetworkError();
			System.out.println("Training completed in " + bp.getCurrentIteration() + " iterations, ");
			System.out.println("With total error: " + formatDecimalNumber(error));
		} else {
			System.out.println(
					"Iteration: " + bp.getCurrentIteration() + " | Network error: " + bp.getTotalNetworkError());
		}
	}

	
	/**
	 * @param number
	 * @return String return String value of max error value
	 */
	private String formatDecimalNumber(double number) {
		return new BigDecimal(number).setScale(5, RoundingMode.HALF_UP).toString();
	}
	

	/**
	 * @param config
	 * @param input
	 * @return Double[] numeric value of neural network output
	 * @throws NeurophException
	 */
	public double[] getMappingModel(NetworkConfiguration config, double[] input) {
		try {
			// create input parameters for evaluate
			DataSet testDataSet = new DataSet(4);
			// double input[] = { 3.0,2.0,1.0,0.0 };
			testDataSet.addRow(input);
			DataSetRow trainingElement = testDataSet.getRowAt(0);

			// load trained neural network

			MultiLayerPerceptron trainedNetwork = (MultiLayerPerceptron) NeuralNetwork
					.createFromFile(config.getTrainedNetworkFileName());
			// push input parameters to the network
			trainedNetwork.setInput(trainingElement.getInput());
			// process network
			trainedNetwork.calculate();
			// get output from network
			double[] networkOutput = trainedNetwork.getOutput();
			System.out.print(new Date() + " Input: " + Arrays.toString(trainingElement.getInput()));
			System.out.println(" Output: " + Arrays.toString(networkOutput));
			return networkOutput;
		} catch (NeurophException ex) {
			double[] error = { 999.99, 999.99 };
			System.out.println("Exception: " + ex);
			return error;

		}

	}

	/**
	 * @param config
	 * @param networkOutput
	 * @return String  mapping model name
	 * @description method to return mapping model name
	 */
	public String returnMappingModelName(NetworkConfiguration config, double networkOutput) {
		// evaluate network output comparing constant values for mapping models
		if (networkOutput < config.getMIDDLE_VALUE() || networkOutput == config.getMIDDLE_VALUE()) {
			System.out.println("Select embedding: " + networkOutput);
			return config.getEMBEDDING_NAME();

		}
		// evaluate network output comparing constant values for mapping models
		else if (networkOutput > config.getMIDDLE_VALUE() && networkOutput != 999.99) {
			System.out.println("Select referencing: " + networkOutput);
			return config.getREFERENCING_NAME();

		}
		// network has returned error code so no way to predict
		return config.getUNABLE_TO_PREDICT_NAME();

	}

}