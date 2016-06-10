package org.migdb.migdbserver.main.resources;

public class MappingRequestMessage {
	// designed temporary upto 121 and 12M relationships
	private String clientId;
	private String requestId;
	private String authorizationKey;
	private String relationshipType;

	private int columnCount;
	private int numericCount;
	private int stringCount;
	private int calenderCount;

	public MappingRequestMessage(String clientId, String requestId, String authorizationKey, String relationshipType,
			int columnCount, int numericCount, int stringCount, int calenderCount) {
		this.clientId = clientId;
		this.requestId = requestId;
		this.authorizationKey = authorizationKey;
		this.relationshipType = relationshipType;
		this.columnCount = columnCount;
		this.numericCount = numericCount;
		this.stringCount = stringCount;
		this.calenderCount = calenderCount;

	}

	public MappingRequestMessage() {

	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getAuthorizationKey() {
		return authorizationKey;
	}

	public void setAuthorizationKey(String authorizationKey) {
		this.authorizationKey = authorizationKey;
	}

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public int getNumericCount() {
		return numericCount;
	}

	public void setNumericCount(int numericCount) {
		this.numericCount = numericCount;
	}

	public int getStringCount() {
		return stringCount;
	}

	public void setStringCount(int stringCount) {
		this.stringCount = stringCount;
	}

	public int getCalenderCount() {
		return calenderCount;
	}

	public void setCalenderCount(int calenderCount) {
		this.calenderCount = calenderCount;
	}

	public double[] convertParamToArray() {
		double[] paramArray = { Double.valueOf(this.getColumnCount()), Double.valueOf(this.getNumericCount()),
				Double.valueOf(this.getStringCount()), Double.valueOf(this.getCalenderCount()) };
		return paramArray;

	}

}
