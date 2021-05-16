package com.nkhil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nkhil.dao.SysUser;

@Repository
public interface SysUserRepository {

	SysUser findById(String id);
	
	List<SysUser> loadAllSysUser();
}
