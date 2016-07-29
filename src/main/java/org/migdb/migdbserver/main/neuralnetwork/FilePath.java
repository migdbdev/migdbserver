package org.migdb.migdbserver.main.neuralnetwork;

import java.io.File;

public enum FilePath {

	DOCUMENT(System.getProperty("user.home") + File.separator + "Documents"+File.separator+"MigDB"+File.separator+"NeuralNetwork"+File.separator),
	TRAININGSET("tableinfo.txt"),
	TRAINEDNETWORK("trainedNetwork.txt"),
	EMPTYNETWORK("emptyNetwork.txt"),
	COLLECTIONSTORE(System.getProperty("user.home") + File.separator + "Documents"+File.separator+"MigDB"+File.separator+"CollectionStore"+File.separator);

	private String path;

	FilePath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
