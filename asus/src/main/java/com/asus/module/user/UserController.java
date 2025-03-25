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
	public String UserXdmList(Model model) {
		
		model.addAttribute("list", userService.selectList());
		return "xdm/user/UserXdmList";
	}
}
