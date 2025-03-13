package com.asus.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired //인터페이스
	IndexService indexSerice;
	
	@RequestMapping(value = "/xdm/index/IndexXdmList")
	public String IndexXdmList(Model model) {
		
		return "xdm/index/IndexXdmList"; 
		}

}
