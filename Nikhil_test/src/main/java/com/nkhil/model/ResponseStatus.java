package com.nkhil.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseStatus {

	Integer errNo;
	String errMsg;

}