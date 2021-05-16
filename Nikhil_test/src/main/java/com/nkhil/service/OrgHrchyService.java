package com.nkhil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkhil.Exception.CommonValidationException;
import com.nkhil.dao.OrgHrchy;
import com.nkhil.model.OrgHrchyModel;
import com.nkhil.repository.OrgHrchyRepository;
import com.nkhil.util.CommonValidationErrors;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrgHrchyService {
	
	@Autowired
	OrgHrchyRepository orgHrchyRepository;

	public void saveDetails(OrgHrchyModel orgHrchyModel) {
		
		if(isValid(orgHrchyModel.getOrgHrchy())) {
			log.info("saved ::{}",orgHrchyRepository.saveOrgHrchy(orgHrchyModel.getOrgHrchy()));
		}
		else
			throw new CommonValidationException(CommonValidationErrors.SERVER_ERROR.errorCode, CommonValidationErrors.SERVER_ERROR.errorMessage);
	}
	
	public void updateDetails(OrgHrchyModel orgHrchyModel) {
		
		if(isValid(orgHrchyModel.getOrgHrchy())) {
			orgHrchyRepository.updateOrgHrchy(orgHrchyModel.getOrgHrchy());
		}
		else
			throw new CommonValidationException(CommonValidationErrors.SERVER_ERROR.errorCode, CommonValidationErrors.SERVER_ERROR.errorMessage);
	}

	private boolean isValid(OrgHrchy orgHrchy) {
		// TODO add validations 
		return true;
	}

	
	public List<OrgHrchy> getAllOrgHrchy() {
		
		return orgHrchyRepository.loadAllOrgHrchy();
	}

}
