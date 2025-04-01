package com.asus.pro.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired //인터페이스
	IndexService indexSerice;
	
	@RequestMapping(value = "/xdm/usr/index/IndexUsrList")
	public String IndexUsrList(Model model) {
		
		return "xdm/usr/index/IndexUsrList"; 
		}

}


