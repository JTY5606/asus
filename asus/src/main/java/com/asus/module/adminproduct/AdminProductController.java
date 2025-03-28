package com.asus.module.adminproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminProductController {
	
	@Autowired //인터페이스
	AdminProductService adminProductService;
	
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmList")
	public String AdminProductXdmList(Model model) {
		
		model.addAttribute("list", adminProductService.selectList());
		
		return "xdm/adminproduct/AdminProductXdmList"; 
		}
	
	

}
