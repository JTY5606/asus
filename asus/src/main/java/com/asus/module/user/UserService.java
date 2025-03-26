package com.asus.module.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asus.module.code.CodeDto;
import com.asus.module.code.CodeVo;
import com.asus.module.codegroup.CodeGroupDto;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserDto> selectList() {
		List<UserDto> userDtos = new ArrayList<>();
		
		userDtos = userDao.selectList();
		
		return userDtos;
	}
	
	public UserDto selectSigin(UserDto userDto) {
		return userDao.selectSigin(userDto);
	}
}
