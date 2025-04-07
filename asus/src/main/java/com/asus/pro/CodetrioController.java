package com.asus.pro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodetrioController {
	
	@RequestMapping(value = "/xdm/codetrioList")
	public String codetrioList(Model model) {
		
		return "xdm/codetrioList"; 
		}
	

}
