package com.asus.pro.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@Autowired //인터페이스
	ProductService productService;
	
	@RequestMapping(value = "/xdm/usr/product/ProductUsrList")
	public String LoginUsrList(Model model) {
		
		return "xdm/usr/product/ProductUsrList"; 
		}

}
