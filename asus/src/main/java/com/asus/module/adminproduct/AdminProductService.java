package com.asus.module.adminproduct;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminProductService {
	
	@Autowired
	AdminProductDao adminProductDao;
	
	public List<AdminProductDto> selectList() {
		List<AdminProductDto> adminProductDtos = new ArrayList<>();
		
		adminProductDtos = adminProductDao.selectList();
		
		return adminProductDtos; 	
	}

}
