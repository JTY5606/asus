package com.asus.module.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	
	public List<UserDto> selectList(UserVo vo);
	public UserDto selectSigin(UserDto userDto);
	public int selectOneCount(UserVo vo);
	public UserDto selectOne(UserVo vo);
	public int insert(UserDto userDto);
}
