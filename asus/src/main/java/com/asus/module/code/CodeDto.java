package com.asus.module.code;

import java.util.ArrayList;
import java.util.List;

public class CodeDto {
	
	private String seq;
	private Integer delNy;
	private String codegroupcode;
	private String title;
	private Integer code;
	private String codename;
	private Integer number;
	private String codegroup_seq;
	
	private String codegroupseq;
	private String name;
	
//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	public String getCodegroupseq() {
		return codegroupseq;
	}
	public void setCodegroupseq(String codegroupseq) {
		this.codegroupseq = codegroupseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodegroup_seq() {
		return codegroup_seq;
	}
	public void setCodegroup_seq(String codegroup_seq) {
		this.codegroup_seq = codegroup_seq;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Integer getDelNy() {
		return delNy;
	}
	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}
	public String getCodegroupcode() {
		return codegroupcode;
	}
	public void setCodegroupcode(String codegroupcode) {
		this.codegroupcode = codegroupcode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getCodename() {
		return codename;
	}
	public void setCodename(String codename) {
		this.codename = codename;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
	
	
	

}
