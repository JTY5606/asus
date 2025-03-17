package com.asus.module.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	public List<CodeDto> selectList(CodeVo vo) {
		List<CodeDto> codeDtos = new ArrayList<>();
		
		codeDtos = codeDao.selectList(vo);
		
		return codeDtos; 
	}
	
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);
	}
	public int uelete(CodeDto codeDto) {
		return codeDao.uelete(codeDto);
	}
	public int selectOneCount() {
		return codeDao.selectOneCount();
	}
}
