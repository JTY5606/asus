package com.asus.module.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asus.module.adminproduct.AdminProductVo;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserDto> selectList(UserVo vo) {
		List<UserDto> userDtos = new ArrayList<>();
		
		userDtos = userDao.selectList(vo);
		
		return userDtos;
	}
	
	public List<UserDto> selectTwo(UserDto userDto){
		return userDao.selectTwo(userDto);
	}
	
	public UserDto selectSigin(UserDto userDto) {
		return userDao.selectSigin(userDto);
	}
	
	public UserDto selectSigup(UserDto userDto) {
		return userDao.selectSigup(userDto);
	}
	
	public int selectOneCount(UserVo vo) {
		return userDao.selectOneCount(vo);
	}
	public int selectTwoCount(UserDto userDto) {
		return userDao.selectTwoCount(userDto);
	}
	public UserDto selectOne(UserVo vo) {
		return userDao.selectOne(vo);
	}
	public List<UserDto> selectReview(AdminProductVo Vo) {
		return userDao.selectReview(Vo);
	}
	
	public int insertReview(UserDto userDto) {
		return userDao.insertReview(userDto);
	}
	
	public int insert(UserDto userDto) {
		return userDao.insert(userDto);
	}
	
	public int insertaddress(UserDto userDto) {
		return userDao.insertaddress(userDto);
	}
	
	public int update(UserDto userDto) {
		return userDao.update(userDto);
	}
	
	public int uelete(UserDto userDto) {
		return userDao.uelete(userDto);
	}
	
	public int updatepassword(UserDto userDto) {
		return userDao.updatepassword(userDto);
	}
	public int changeaddress(UserDto userDto) {
		return userDao.changeaddress(userDto);
	}
	//비밀번호 변경
	public UserDto passwordcheck(UserDto userDto) {
		return userDao.passwordcheck(userDto);
	}
	
}
