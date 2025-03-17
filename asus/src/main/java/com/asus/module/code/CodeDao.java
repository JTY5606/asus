package com.asus.module.code;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	public List<CodeDto> selectList(CodeVo vo);
	public int insert(CodeDto codeDto);
	public int uelete(CodeDto codeDto);
	public int selectOneCount();

}
