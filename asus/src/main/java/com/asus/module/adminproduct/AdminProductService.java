package com.asus.module.adminproduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asus.module.codegroup.CodeGroupDto;
import com.asus.module.codegroup.CodeGroupVo;
import com.asus.module.user.UserVo;

@Service
public class AdminProductService {
	
	@Autowired
	AdminProductDao adminProductDao;
	
	public List<AdminProductDto> selectList(AdminProductVo vo) {
		List<AdminProductDto> adminProductDtos = new ArrayList<>();
		
		adminProductDtos = adminProductDao.selectList(vo);
		
		return adminProductDtos; 	
	}
	public int selectOneCount(AdminProductVo vo) {
		return adminProductDao.selectOneCount(vo);
	}
	public AdminProductDto selectOne(AdminProductVo vo) {
		return adminProductDao.selectOne(vo);
	}
	
	public int insert(AdminProductDto adminProductDto) {
		return adminProductDao.insert(adminProductDto);
	}
}
