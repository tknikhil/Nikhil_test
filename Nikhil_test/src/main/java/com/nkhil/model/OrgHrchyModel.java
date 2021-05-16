package com.nkhil.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.nkhil.dao.OrgHrchy;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonDeserialize(builder = OrgHrchyModel.OrgHrchyModelBuilder.class)
public class OrgHrchyModel {
	
	private OrgHrchy orgHrchy;
	
	@JsonPOJOBuilder(withPrefix = "")
	public static class OrgHrchyModelBuilder {
	}
	
}
