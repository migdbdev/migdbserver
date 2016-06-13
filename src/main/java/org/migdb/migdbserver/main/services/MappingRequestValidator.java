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
package org.migdb.migdbserver.main.services;

import org.migdb.migdbserver.main.config.ErrorCodes;
import org.migdb.migdbserver.main.exceptions.RequestMessageParameterException;
import org.migdb.migdbserver.main.resources.MappingRequestMessage;

/**
 * @author Gayan
 * @description class to validate mapping request message
 *
 */
public class MappingRequestValidator {

	private MappingRequestMessage mappingrequest;
	private int sumOfColumn = -1;

	/**
	 * @param mappingrequest
	 * @description constructor
	 */
	public MappingRequestValidator(MappingRequestMessage mappingrequest) {

		this.mappingrequest = mappingrequest;
		this.sumOfColumn = mappingrequest.getCalenderCount() + mappingrequest.getNumericCount()
				+ mappingrequest.getStringCount();

	}

	/**
	 * @description validate request authentication and parameters
	 */
	public void validateMappingRequest() {
		validateMessageParameters();
		validateMessageAuthentication();

	}

	/**
	 * @return Boolean messageParameterValidStatus
	 * @throws  RequestMessageParameterException
	 */
	public boolean validateMessageParameters() {
		if (mappingrequest.getColumnCount() < 0) {
			String message = "@REQUESTID:" + mappingrequest.getRequestId() + "-->@ERRORINFOID:"
					+ ErrorCodes.COLUM_COUNT_INVALID;
			throw new RequestMessageParameterException(message);
		}
		if (mappingrequest.getCalenderCount() < 0) {
			String message = "@REQUESTID:" + mappingrequest.getRequestId() + "-->@ERRORINFOID:"
					+ ErrorCodes.CALENDER_COUNT_INVALID;
			throw new RequestMessageParameterException(message);
		}
		if (mappingrequest.getNumericCount() < 0) {
			String message = "@REQUESTID:" + mappingrequest.getRequestId() + "-->@ERRORINFOID:"
					+ ErrorCodes.NUMERIC_COUNT_INVALID;
			throw new RequestMessageParameterException(message);
		}
		if (mappingrequest.getStringCount() < 0) {
			String message = "@REQUESTID:" + mappingrequest.getRequestId() + "-->@ERRORINFOID:"
					+ ErrorCodes.STRING_COUNT_INVALID;
			throw new RequestMessageParameterException(message);
		}
		if (mappingrequest.getColumnCount() < sumOfColumn) {
			String message = "@REQUESTID:" + mappingrequest.getRequestId() + "-->@ERRORINFOID:"
					+ ErrorCodes.COLUM_COUNT_INVALID;
			throw new RequestMessageParameterException(message);
		}

		return false;
	}

	/**
	 * @return
	 */
	public boolean validateMessageAuthentication() {
		//already check basic authentication by jersey framework
		return false;
	}

}
