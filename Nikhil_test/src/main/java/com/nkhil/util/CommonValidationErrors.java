package com.nkhil.util;

public enum CommonValidationErrors {
	
	SUCCESS(0,"success"),
	
	ACTIVE_USER(0,"User is active"),
	
	AUTHORIZED_USER(4,"Authorized user"),
	
	INVALID_USER(1,"Invalid user"),
	
	INVALID_PASSWORD(1,"Invalid password"),
	
	INVALID_USER_PASSWORD(1,"Invalid user and password"),
	
	INACTIVE_USER(1,"User is inactive"),
	
	UNAUTHORIZED_USER(1,"User is not authorized"),
	
	SERVER_ERROR(1,"Server error");
	
	
	public final int errorCode;
	public final String errorMessage;
	
	private CommonValidationErrors(int errorCode, String errorMessage) {
		this.errorCode= errorCode;
		this.errorMessage= errorMessage;
	}
}
