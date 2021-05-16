package com.nkhil.repository.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.nkhil.dao.SysUser;
import com.nkhil.repository.CommonMethods;
import com.nkhil.repository.SysUserRepository;

public class SysUserRepositoryImpl implements SysUserRepository, CommonMethods<SysUser>{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public SysUser findById(String id) {
        return findById(sessionFactory.getCurrentSession(), SysUser.class, id);
	}

	@Override
	public List<SysUser> loadAllSysUser() {
		return  findAll(sessionFactory.getCurrentSession(), SysUser.class);
	}


}
