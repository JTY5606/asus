package com.asus.module.codegroup;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	
	@Autowired
	CodeGroupDao codeGroupDao;
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo) {
		List<CodeGroupDto> codeGroupDtos = new ArrayList<>();
		
		codeGroupDtos = codeGroupDao.selectList(vo);
		
		return codeGroupDtos; 
	}
	
	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
	}
	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto);
	}
	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto);
	}
	public CodeGroupDto selectItem(CodeGroupDto codeGroupDto) {
		return codeGroupDao.selectItem(codeGroupDto);
	}
	public CodeGroupDto selectOne(CodeGroupVo vo) {
		return codeGroupDao.selectOne(vo);
	}
	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto);
	}
	public int selectOneCount(CodeGroupVo vo) {
		return codeGroupDao.selectOneCount(vo);
	}
	public List<CodeGroupDto> selectListWithoutPaging(CodeGroupDto codeGroupDto){
		return codeGroupDao.selectListWithoutPaging(codeGroupDto);
	}
}
