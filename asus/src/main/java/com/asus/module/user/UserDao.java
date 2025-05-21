package com.asus.module.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.asus.module.adminproduct.AdminProductVo;

@Repository
public interface UserDao {
	
	
	public List<UserDto> selectList(UserVo vo);
	public List<UserDto> selectTwo(UserDto userDto);
	public UserDto selectSigin(UserDto userDto);
	public UserDto selectSigup(UserDto userDto);
	public int selectOneCount(UserVo vo);
	public int selectTwoCount(UserDto userDto);
	public UserDto selectOne(UserVo vo);
	public List<UserDto> selectReview(AdminProductVo Vo);
	public int insertaddress(UserDto userDto);
	public int insertReview(UserDto userDto);
	public int update(UserDto userDto);
	public int uelete(UserDto userDto);
	public int changeaddress(UserDto userDto);
	
	public int updatepassword(UserDto userDto);
	
	public UserDto passwordcheck(UserDto userDto);
	
	public int insert(UserDto userDto);
}
