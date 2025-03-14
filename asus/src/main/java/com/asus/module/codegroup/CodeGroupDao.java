package com.asus.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo);
	public int insert(CodeGroupDto codeGroupDto);
	public CodeGroupDto selectItem(CodeGroupDto codeGroupDto);
	public int delete(CodeGroupDto codeGroupDto);
	public int selectOneCount();
}
