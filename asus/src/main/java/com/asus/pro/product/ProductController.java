package com.asus.pro.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asus.module.adminproduct.AdminProductVo;

@Controller
public class ProductController {
	
	@Autowired //인터페이스
	ProductService productService;
	

}
