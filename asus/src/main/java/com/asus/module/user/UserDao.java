package com.asus.module.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	
	public List<UserDto> selectList();
	public UserDto selectSigin(UserDto userDto);

}
