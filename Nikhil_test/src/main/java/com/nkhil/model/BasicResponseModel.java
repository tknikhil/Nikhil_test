package com.nkhil.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasicResponseModel {
	
	private ResponseStatus result;
	
}
