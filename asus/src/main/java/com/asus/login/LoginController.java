package com.asus.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@Autowired //인터페이스
	LoginService loginServive;
	
	@RequestMapping(value = "/xdm/login/LoginXdmList")
	public String LoginXdmList(Model model) {
		
		return "xdm/login/LoginXdmList"; 
		}

}
