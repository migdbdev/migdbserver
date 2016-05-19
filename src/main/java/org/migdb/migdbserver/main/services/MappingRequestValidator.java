package org.migdb.migdbserver.main.services;

import org.migdb.migdbserver.main.config.ErrorCodes;
import org.migdb.migdbserver.main.exceptions.RequestMessageParameterException;
import org.migdb.migdbserver.main.resources.MappingRequestMessage;

public class MappingRequestValidator {
	
	private MappingRequestMessage mappingrequest;
	private int sumOfColumn = -1;
	
	
	
	
	public MappingRequestValidator(MappingRequestMessage mappingrequest) {
		
		this.mappingrequest = mappingrequest;
		this.sumOfColumn = mappingrequest.getCalenderCount()+mappingrequest.getNumericCount()+mappingrequest.getStringCount();
		
	}

	public void validateMappingRequest(){
		validateMessageParameters();
		validateMessageAuthentication();
		
	}
	
	public boolean validateMessageParameters(){
		if(mappingrequest.getColumnCount() < 0 ){
		String message = "@REQUESTID:"+mappingrequest.getRequestId()+"-->@ERRORINFOID:"+ErrorCodes.COLUM_COUNT_INVALID;
		throw new RequestMessageParameterException(message);
		}
		if(mappingrequest.getCalenderCount() < 0 ){
			String message = "@REQUESTID:"+mappingrequest.getRequestId()+"-->@ERRORINFOID:"+ErrorCodes.CALENDER_COUNT_INVALID;
			throw new RequestMessageParameterException(message);
			}
		if(mappingrequest.getNumericCount() < 0 ){
			String message = "@REQUESTID:"+mappingrequest.getRequestId()+"-->@ERRORINFOID:"+ErrorCodes.NUMERIC_COUNT_INVALID;
			throw new RequestMessageParameterException(message);
			}
		if(mappingrequest.getStringCount() < 0 ){
			String message = "@REQUESTID:"+mappingrequest.getRequestId()+"-->@ERRORINFOID:"+ErrorCodes.STRING_COUNT_INVALID;
			throw new RequestMessageParameterException(message);
			}
		if(mappingrequest.getColumnCount() < sumOfColumn ){
			String message = "@REQUESTID:"+mappingrequest.getRequestId()+"-->@ERRORINFOID:"+ErrorCodes.COLUM_COUNT_INVALID;
			throw new RequestMessageParameterException(message);
			}
		
		return false;
	}
	
	public boolean validateMessageAuthentication(){
		
		return false;
	}

}
