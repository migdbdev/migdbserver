package org.migdb.migdbserver.main.resources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorNo;
	private String errorMessage;
	private String documentation;

	public ErrorMessage() {

	}

	public ErrorMessage(String errorNo, String errorMessage, String documentation) {

		this.errorNo = errorNo;
		this.errorMessage = errorMessage;
		this.documentation = documentation;
	}

	public String getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

}
