package com.asus.module.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	public List<UserDto> selectList(UserVo vo);
	public int selectOneCount();
	public UserDto selectItem(UserDto userDto);
	
}
