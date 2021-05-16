package com.nkhil.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="ORG_HRCHY")
//@Table(name="ORG_HRCHY")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgHrchy {
	
	@Column(name="HRCHY_CODE")
	@Id
	private String hrchyCode;
	
	@Column(name="HRCHY_L_NM")
	private String hrchyLNm ;
	
	@Column(name="HRCHY_F_NM")
	private String hrchyFNm ;
	
	@Column(name="HRCHY_CODE_PARNT")
	private String hrchyCodeParnt;
	
	@Column(name="HRCHY_TYP")
	private String hrchyTyp;
	
	@Column(name="UNT_NO")
	private int untNo;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="INACTV_FLG")
	private int inactvFlg;

}
