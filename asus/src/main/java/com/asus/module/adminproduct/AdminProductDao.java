package com.asus.module.adminproduct;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminProductDao {
	
	public List<AdminProductDto> selectList();
	
	

}
