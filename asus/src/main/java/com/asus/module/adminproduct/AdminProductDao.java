package com.asus.module.adminproduct;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asus.module.codegroup.CodeGroupDto;
import com.asus.module.codegroup.CodeGroupVo;
import com.asus.module.user.UserVo;

@Repository
public interface AdminProductDao {
	
	public List<AdminProductDto> selectList(AdminProductVo vo);
	
	public int selectOneCount(AdminProductVo vo); 
	public AdminProductDto selectOne(AdminProductVo vo);
	public int insert(AdminProductDto adminProductDto);
	public int update(AdminProductDto adminProductDto);
	public int uelete(AdminProductDto adminProductDto);
	
	public List<AdminProductDto> selectCateList(AdminProductVo vo);
	
	public int selectCateCount(AdminProductVo vo); 
}
