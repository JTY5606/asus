package com.asus.module.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	
	public List<UserDto> selectList(UserVo vo);
	public List<UserDto> selectTwo(UserDto userDto);
	public UserDto selectSigin(UserDto userDto);
	public UserDto selectSigup(UserDto userDto);
	public int selectOneCount(UserVo vo);
	public int selectTwoCount(UserDto userDto);
	public UserDto selectOne(UserVo vo);
	public int insert(UserDto userDto);
	public int insertaddress(UserDto userDto);
	public int update(UserDto userDto);
	public int uelete(UserDto userDto);
	public int changeaddress(UserDto userDto);
	
	public int updatepassword(UserDto userDto);
	
	public UserDto passwordcheck(UserDto userDto);
}
