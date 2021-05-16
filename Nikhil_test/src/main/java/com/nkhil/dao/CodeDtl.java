package com.nkhil.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="CODE_DTL")
//@Table(name="CODE_DTL")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CodeDtl {
	
	@Column(name = "CODE_TYPE")
	private String codeTyp;
	
	@Column(name = "CODE_NO")
	@Id
	private int codeNo;
	
	@Column(name = "CODE_NM")
	private String codeNm;
	
	@Column(name = "INACTV_FLG")
	private String inactvFlg;

}
