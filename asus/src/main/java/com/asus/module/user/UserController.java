package com.asus.module.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/xdm/user/UserXdmList")
	public String UserXdmList(Model model) {
		
		model.addAttribute("list", userService.selectList());
		return "xdm/user/UserXdmList";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/signinXdmProc")
	public Map<String, Object> signinXdmProc(UserDto userDto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		userService.selectSigin(userDto);
		returnMap.put("rt", "success");
		
		
		return returnMap;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(UserDto userDto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		returnMap.put("rt", "success");
		return returnMap;
		
	}
}
