package org.migdb.migdbserver.main.neuralnetwork;

import java.text.DecimalFormat;

import org.migdb.migdbserver.main.resources.MappingRequestMessage;

public class TableComplexityEvaluator {

	NetworkConfiguration config = new NetworkConfiguration();

	public int sumOfTableColumnWeights = 0;
	public int MaxSumOfWeight = config.getMAX_TABLE_WEIGHT();

	public double getsumOfTableWeights(MappingRequestMessage message) {

		sumOfTableColumnWeights += message.getColumnCount() * config.getCOLUMN_WEIGHT();
		sumOfTableColumnWeights += message.getNumericCount() * config.getNUMERIC_WEIGHT();
		sumOfTableColumnWeights += message.getStringCount() * config.getSTRING_WEIGHT();
		sumOfTableColumnWeights += message.getCalenderCount() * config.getCALENDER_WEIGHT();

		System.out.println("sum of complexity :" + sumOfTableColumnWeights);
		DecimalFormat df = new DecimalFormat("#.#####");

		double complexityValue = 0.0;
		if (sumOfTableColumnWeights <= config.getMAX_TABLE_WEIGHT()) {
			complexityValue = (double) sumOfTableColumnWeights / MaxSumOfWeight;
			complexityValue = Double.valueOf(df.format(complexityValue));
		} else {
			complexityValue = 1.00000;
		}

		if (Double.isFinite(complexityValue)) {
			System.out.println("Complexity Value: " + String.valueOf(complexityValue));
			return complexityValue;
		}
		return 0.00000;

	}

}
