package com.asus.pro.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asus.module.adminproduct.AdminProductService;
import com.asus.module.adminproduct.AdminProductVo;

@Controller
public class IndexController {
	
	@Autowired //인터페이스
	IndexService indexSerice;
	@Autowired
	AdminProductService adminProductService;
	
	@RequestMapping(value = "/xdm/usr/index/IndexUsrList")
	public String IndexUsrList(Model model,@ModelAttribute("vo") AdminProductVo vo) {
		
		vo.setParamsPaging(adminProductService.selectOneCount(vo));
		model.addAttribute("list", adminProductService.selectList(vo));
		
		return "xdm/usr/index/IndexUsrList"; 
		}

}


