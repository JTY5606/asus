package com.asus.module.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping(value = "/xdm/user/UserXdmList")
	public String UserXdmList(Model model, UserVo vo) {
		
		vo.setParamsPaging(userService.selectOneCount());
		int a = userService.selectOneCount();
		model.addAttribute("list", userService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/user/UserXdmList"; 
		}
	
	@RequestMapping(value = "/xdm/user/UserXdmView")
	public String UserXdmView(Model model,UserDto userDto,UserVo vo) {
		
		model.addAttribute("item" , userService.selectItem(userDto));
		model.addAttribute(vo);
		return "xdm/user/UserXdmView"; 
		}
	

}
