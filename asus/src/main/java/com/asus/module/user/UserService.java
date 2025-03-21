package com.asus.module.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserDto> selectList(UserVo vo) {
		List<UserDto> userDtos = new ArrayList<>();
		
		userDtos = userDao.selectList(vo);
		
		return userDtos; 
	}
	
	public int selectOneCount() {
		return userDao.selectOneCount();
	}
	
	public UserDto selectItem(UserDto userDto) {
		return userDao.selectItem(userDto);
	}

}
