package com.nkhil.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nkhil.dao.CodeDtl;
import com.nkhil.repository.CodeDtlRepository;
import com.nkhil.repository.CommonMethods;

public class CodeDtlRepositoryImpl implements CodeDtlRepository, CommonMethods<CodeDtl> {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public CodeDtl findById(String id) {
		return findById(sessionFactory.getCurrentSession(),CodeDtl.class,id);
	}

	@Override
	public List<CodeDtl> loadAllCodeDtl() {
		return findAll(sessionFactory.getCurrentSession(), CodeDtl.class);
	}

	
	

}
