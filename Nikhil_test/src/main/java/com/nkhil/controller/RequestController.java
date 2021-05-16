package com.nkhil.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nkhil.dao.SysUser;
import com.nkhil.model.BasicResponseModel;
import com.nkhil.model.OrgHrchyModel;
import com.nkhil.model.UserSignInModel;
import com.nkhil.service.OrgHrchyService;
import com.nkhil.service.SysUserService;
import com.nkhil.util.CommonValidationErrors;
import com.nkhil.util.ResponseBuilderUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RequestController {

	@Autowired
	SysUserService sysUserService;
	
	@Autowired
	OrgHrchyService orgHrchyService;
	
//	@Autowired
//	ObjectMapper objectMapper;
	
	
	@PostMapping(value="/signin", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public BasicResponseModel signIn(@RequestBody UserSignInModel userSignDetails) {
		log.info("Received value :: {}",userSignDetails);
		try {
			if(sysUserService.isValidUser(userSignDetails))
				return ResponseBuilderUtil.buildResponse(CommonValidationErrors.SUCCESS.errorCode,CommonValidationErrors.SUCCESS.errorMessage);
			else 
				return ResponseBuilderUtil.buildResponse(CommonValidationErrors.INVALID_USER_PASSWORD.errorCode,CommonValidationErrors.INVALID_USER_PASSWORD.errorMessage);
		}
		catch(Exception ex) {
			return ResponseBuilderUtil.buildResponse(ex);
		}
		
	}
	
	@PostMapping(value="/addOrgHrchy", consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public BasicResponseModel addOrgHrchy(@RequestBody OrgHrchyModel orgHrchyModel) {
		log.info("received details to add :: {}",orgHrchyModel);
		try {
				orgHrchyService.saveDetails(orgHrchyModel);
				return ResponseBuilderUtil.buildResponse(CommonValidationErrors.SUCCESS.errorCode,CommonValidationErrors.SUCCESS.errorMessage);
		}
		catch(Exception ex) {
			return ResponseBuilderUtil.buildResponse(ex);
		}
		
	}
	
	@PostMapping(value="/updOrgHrchy", consumes = {MediaType.APPLICATION_JSON_VALUE} )
	public BasicResponseModel updateOrgHrchy(@RequestBody OrgHrchyModel orgHrchyModel) {
		log.info("received details for update :: {}",orgHrchyModel);
		try {
				orgHrchyService.updateDetails(orgHrchyModel);
				return ResponseBuilderUtil.buildResponse(CommonValidationErrors.SUCCESS.errorCode,CommonValidationErrors.SUCCESS.errorMessage);
		}
		catch(Exception ex) {
			return ResponseBuilderUtil.buildResponse(ex);
		}
		
	}
	
	@GetMapping(value="/orgHrchyList", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Object> getAllOrgHrchy() throws Exception {
		log.info("getAllOrgHrchy");

		try {
				log.info("Esponse :: {} ",orgHrchyService.getAllOrgHrchy());
				return new ResponseEntity<>(Map.of("orgHrchyList",orgHrchyService.getAllOrgHrchy()),HttpStatus.OK);
		}
		catch(Exception ex) {
			log.error("Exception :: ",ex);
			return new ResponseEntity<>(ResponseBuilderUtil.buildResponse(ex),HttpStatus.OK);
		}
		
	}
	
	
	
}
