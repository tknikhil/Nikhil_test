package com.nkhil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nkhil.Exception.CommonValidationException;
import com.nkhil.dao.SysUser;
import com.nkhil.model.UserSignInModel;
import com.nkhil.repository.SysUserRepository;
import com.nkhil.util.CommonValidationErrors;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysUserService {
	
	@Autowired
	SysUserRepository repository;

	public SysUser signInUser(UserSignInModel signIn) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isValidUser(UserSignInModel userSignDetails) {

		SysUser sysUser = repository.findById(userSignDetails.getUserName());
		log.info("retrived :: {}",sysUser);
		if(validateUser(sysUser,userSignDetails)) {
			// TODO :: post login activities and audit trail
		}
		return true;
	}

	private boolean validateUser(SysUser sysUser, UserSignInModel userSignDetails) {
		
		if(sysUser == null)
			throw new CommonValidationException(CommonValidationErrors.INVALID_USER.errorCode, CommonValidationErrors.INVALID_USER.errorMessage);
		if(!validatePassword(sysUser.getPassword(),userSignDetails.getPassword()))
			throw new CommonValidationException(CommonValidationErrors.INVALID_PASSWORD.errorCode, CommonValidationErrors.INVALID_PASSWORD.errorMessage);
		if(sysUser.getInactvFlg()!= CommonValidationErrors.ACTIVE_USER.errorCode)
			throw new CommonValidationException(CommonValidationErrors.INACTIVE_USER.errorCode, CommonValidationErrors.INACTIVE_USER.errorMessage);
		if(sysUser.getGrpNo()!=  CommonValidationErrors.AUTHORIZED_USER.errorCode)
			throw new CommonValidationException(CommonValidationErrors.UNAUTHORIZED_USER.errorCode, CommonValidationErrors.UNAUTHORIZED_USER.errorMessage);
		return true;
	}

	private boolean validatePassword(String password, String password2) {
		// TODO :: validate based on specific encryption
		log.info("retrived check ::{}=={}--{}",password,password2,password.equals(password2));
		return password.equals(password2);
	}

}
