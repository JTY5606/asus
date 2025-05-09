package com.asus.module.adminproduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminProductController {
	
	@Autowired //인터페이스
	AdminProductService adminProductService;
	
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmList")
	public String AdminProductXdmList(Model model,@ModelAttribute("vo") AdminProductVo vo) {
		
		vo.setParamsPaging(adminProductService.selectOneCount(vo));
		if (vo.getTotalRows() > 0) {

			model.addAttribute("list", adminProductService.selectList(vo));

			}
		
		return "xdm/adminproduct/AdminProductXdmList"; 
		}
	
	@RequestMapping(value = "/xdm/usr/productlist/ProductListUsrList")
	public String ProuctListUsrList(Model model,@ModelAttribute("vo") AdminProductVo vo ) {
		
		model.addAttribute("list", adminProductService.selectList(vo));
		return "xdm/usr/productlist/ProductListUsrList"; 
		}
	
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmForm")
	public String AdminProductXdmForm(@ModelAttribute("vo") AdminProductVo vo, Model model) throws Exception{
		if (vo.getIfprseq().equals("0") || vo.getIfprseq().equals("")) {
		//			insert mode
	} else {
//				update mode
	model.addAttribute("item", adminProductService.selectOne(vo));
//	model.addAttribute("list", codeService.selectList(cvo));
	}
	return  "xdm/adminproduct/AdminProductXdmForm";
	}
	
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmInst")
	public String AdminProductXdmInst(AdminProductDto adminProductDto) {
		
		adminProductService.insert(adminProductDto);
		return "redirect:/xdm/adminproduct/AdminProductXdmList"; 
		}
	
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmUpdt")
	public String AdminProductXdmUpdt(AdminProductDto adminProductDto) {
		adminProductService.update(adminProductDto);
		return "redirect:/xdm/adminproduct/AdminProductXdmList"; 
		}
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmUele")
	public String AdminProductXdmUele(AdminProductDto adminProductDto) {
		adminProductService.uelete(adminProductDto);
		return "redirect:/xdm/adminproduct/AdminProductXdmList"; 
		}
}
