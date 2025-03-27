package com.asus.module.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asus.module.code.CodeDto;
import com.asus.module.code.CodeVo;
import com.asus.module.codegroup.CodeGroupDto;
import com.asus.module.codegroup.CodeGroupVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserDto> selectList(UserVo vo) {
		List<UserDto> userDtos = new ArrayList<>();
		
		userDtos = userDao.selectList(vo);
		
		return userDtos;
	}
	
	public UserDto selectSigin(UserDto userDto) {
		return userDao.selectSigin(userDto);
	}
	public int selectOneCount(UserVo vo) {
		return userDao.selectOneCount(vo);
	}
	public UserDto selectOne(UserVo vo) {
		return userDao.selectOne(vo);
	}
	
	public int insert(UserDto userDto) {
		return userDao.insert(userDto);
	}
}
