package com.nkhil.util;

import com.nkhil.Exception.CommonValidationException;
import com.nkhil.model.BasicResponseModel;
import com.nkhil.model.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResponseBuilderUtil {

	public static BasicResponseModel buildResponse(Exception ex) {
		if(ex instanceof CommonValidationException)
			return buildResponse(((CommonValidationException)ex).getErrorCode(),((CommonValidationException)ex).getErrorMessage());
		return buildResponse(1,ex.getMessage());
	}

	public static BasicResponseModel buildResponse(int errorCode, String statusMessage) {
		return BasicResponseModel.builder()
				.result(new ResponseStatus(errorCode,statusMessage))
				.build();
	}
	
	
		
}
