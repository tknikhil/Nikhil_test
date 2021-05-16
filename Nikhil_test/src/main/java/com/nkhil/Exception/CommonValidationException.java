package com.nkhil.Exception;

import lombok.Getter;

public class CommonValidationException extends RuntimeException {
	
	@Getter
	private int errorCode;
	@Getter
	private String errorMessage;
	
	public CommonValidationException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
