package com.nkhil.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="SYS_USER")
//@Table(name="SYS_USER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
	
	@Column(name="USER_NO")
	private String userNo;
	
	@Column(name="USER_NAME")
	@Id
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="GRP_NO")
	private int grpNo;
	
	@Column(name="INACTV_FLG")
	private int inactvFlg;
	
}
