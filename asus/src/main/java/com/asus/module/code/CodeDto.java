package com.asus.module.code;

import java.util.ArrayList;
import java.util.List;

public class CodeDto {
	
	private String ifcdseq;
	private Integer ifcddelNy;
	private String ifcdcodename;
	private String codegroup_ifcgseq;
	
	private String ifcdname;
	private String ifcgseq;
	
	public String getIfcdname() {
		return ifcdname;
	}
	public void setIfcdname(String ifcdname) {
		this.ifcdname = ifcdname;
	}
	public String getIfcgseq() {
		return ifcgseq;
	}
	public void setIfcgseq(String ifcgseq) {
		this.ifcgseq = ifcgseq;
	}
	public String getIfcdseq() {
		return ifcdseq;
	}
	public void setIfcdseq(String ifcdseq) {
		this.ifcdseq = ifcdseq;
	}
	public Integer getIfcddelNy() {
		return ifcddelNy;
	}
	public void setIfcddelNy(Integer ifcddelNy) {
		this.ifcddelNy = ifcddelNy;
	}
	public String getIfcdcodename() {
		return ifcdcodename;
	}
	public void setIfcdcodename(String ifcdcodename) {
		this.ifcdcodename = ifcdcodename;
	}
	public String getCodegroup_ifcgseq() {
		return codegroup_ifcgseq;
	}
	public void setCodegroup_ifcgseq(String codegroup_ifcgseq) {
		this.codegroup_ifcgseq = codegroup_ifcgseq;
	}
	public String getIfcgname() {
		return ifcdname;
	}
	public void setIfcgname(String ifcdname) {
		this.ifcdname = ifcdname;
	}
	//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	
	
	
	
	
	

}
