package com.nkhil.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = UserSignInModel.UserSignInModelBuilder.class)
public class UserSignInModel {
	
	String userName;
	String password;
	
	@JsonPOJOBuilder(withPrefix = "")
	public static class UserSignInModelBuilder{
	}

}
