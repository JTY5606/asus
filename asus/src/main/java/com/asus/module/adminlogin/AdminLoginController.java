package com.asus.module.adminlogin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLoginController {
	
	@RequestMapping(value = "/xdm/adminlogin/AdminLoginXdmList")
	public String AdminLoginXdmList() {
		
		return "xdm/adminlogin/AdminLoginXdmList"; 
		}

}
