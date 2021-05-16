package com.nkhil.repository.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nkhil.dao.OrgHrchy;
import com.nkhil.repository.CommonMethods;
import com.nkhil.repository.OrgHrchyRepository;

public class OrgHrchyRepositoryImpl implements OrgHrchyRepository, CommonMethods<OrgHrchy> {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public OrgHrchy findById(String id) {
		return findById(sessionFactory.getCurrentSession(), OrgHrchy.class, id);
	}

	@Override
	public List<OrgHrchy> loadAllOrgHrchy() {
		return findAll(sessionFactory.getCurrentSession(), OrgHrchy.class);
	}

	@Override
	public OrgHrchy saveOrgHrchy(OrgHrchy hrchy) {
		return save(sessionFactory.getCurrentSession(), hrchy);
	}
	
	@Override
	public OrgHrchy updateOrgHrchy(OrgHrchy hrchy) {
		return update(sessionFactory.getCurrentSession(), hrchy);
	}

}
