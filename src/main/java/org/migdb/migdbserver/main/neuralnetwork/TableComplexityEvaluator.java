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
