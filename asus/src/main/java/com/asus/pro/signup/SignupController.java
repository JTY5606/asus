package com.asus.pro.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignupController {

	@Autowired //인터페이스
	SignupService signupServive;
	
	@RequestMapping(value = "/xdm/usr/signup/SignupUsrList")
	public String SignupUsrList(Model model) {
		
		return "xdm/usr/signup/SignupUsrList"; 
		}
}
