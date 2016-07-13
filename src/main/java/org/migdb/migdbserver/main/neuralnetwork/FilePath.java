package org.migdb.migdbserver.main.neuralnetwork;

public enum FilePath {

	DOCUMENT(System.getProperty("user.home") + "\\" + "Documents\\MigDB\\NeuralNetwork"),
	TRAININGSET("\\tableinfo.txt"),
	TRAINEDNETWORK("\\trainedNetwork.txt"),
	EMPTYNETWORK("\\emptyNetwork.txt");

	private String path;

	FilePath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
