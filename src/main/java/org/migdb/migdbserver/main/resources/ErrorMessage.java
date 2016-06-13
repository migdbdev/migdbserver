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
package org.migdb.migdbserver.main.resources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorNo;
	private String errorMessage;
	private String documentation;

	/**
	 * Default constructor
	 */
	public ErrorMessage() {

	}

	/**
	 * @param errorNo
	 * @param errorMessage
	 * @param documentation
	 * Constructor
	 */
	public ErrorMessage(String errorNo, String errorMessage, String documentation) {

		this.errorNo = errorNo;
		this.errorMessage = errorMessage;
		this.documentation = documentation;
	}

	/**
	 * @return errorNo
	 */
	public String getErrorNo() {
		return errorNo;
	}

	/**
	 * @param errorNo
	 */
	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}

	/**
	 * @return  errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return documentation
	 */
	public String getDocumentation() {
		return documentation;
	}

	/**
	 * @param documentation
	 */
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

}
