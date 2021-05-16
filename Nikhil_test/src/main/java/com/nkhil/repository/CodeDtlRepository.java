package com.nkhil.repository;

import java.util.List;

import com.nkhil.dao.CodeDtl;

public interface CodeDtlRepository {
	
	CodeDtl findById(String id);
	
	List<CodeDtl> loadAllCodeDtl();

}
