package com.nkhil.repository;

import java.util.List;

import com.nkhil.dao.OrgHrchy;

public interface OrgHrchyRepository {
	
	OrgHrchy findById(String id);
	
	List<OrgHrchy> loadAllOrgHrchy();
	
	OrgHrchy saveOrgHrchy(OrgHrchy hrchy);
	
	OrgHrchy updateOrgHrchy(OrgHrchy hrchy);

}
