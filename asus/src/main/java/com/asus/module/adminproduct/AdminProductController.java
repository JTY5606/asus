package com.asus.module.adminproduct;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.asus.module.file.FileService;
import com.asus.module.user.UserDto;
import com.asus.module.user.UserService;


@Controller
public class AdminProductController {
	
	@Autowired //인터페이스
	AdminProductService adminProductService;
	@Autowired
	UserService userService;
	@Autowired
	FileService fileService;
	
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmList")
	public String AdminProductXdmList(Model model,@ModelAttribute("vo") AdminProductVo vo) {
		
		vo.setParamsPaging(adminProductService.selectOneCount(vo));
		if (vo.getTotalRows() > 0) {

			model.addAttribute("list", adminProductService.selectList(vo));

			}
		
		return "xdm/adminproduct/AdminProductXdmList"; 
		}
	
	@RequestMapping(value = "/xdm/usr/productlist/ProductListUsrList")
	public String productListUsrList(Model model,@ModelAttribute("vo") AdminProductVo vo ) {
		
		vo.setParamsPaging(adminProductService.selectOneCount(vo));
		model.addAttribute("list", adminProductService.selectList(vo));
		return "xdm/usr/productlist/ProductListUsrList"; 
		}
	
	@RequestMapping(value = "/xdm/usr/product/ProductUsrList")
	public String productUsrList(Model model,@ModelAttribute("vo") AdminProductVo vo) {
		model.addAttribute("item", adminProductService.selectOne(vo));
		model.addAttribute("items", userService.selectReview(vo));
//		userService.insertReview(userDto);
		return "xdm/usr/product/ProductUsrList"; 
		}
	
	
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmForm")
	public String AdminProductXdmForm(@ModelAttribute("vo") AdminProductVo vo, Model model,AdminProductDto adminProductDto) throws Exception{
		if (vo.getIfprseq().equals("0") || vo.getIfprseq().equals("")) {
		//			insert mode
	} else {
//				update mode
	model.addAttribute("item", adminProductService.selectOne(vo));
	adminProductDto.setRseq(adminProductDto.getIfprseq());
	model.addAttribute("images", fileService.selectOne(adminProductDto, "images"));
//	model.addAttribute("list", codeService.selectList(cvo));
	}
	return  "xdm/adminproduct/AdminProductXdmForm";
	}
	
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmInst")
	public String AdminProductXdmInst(AdminProductDto adminProductDto) throws Exception {
		
		adminProductService.insert(adminProductDto);
		// uaSeq로 파일이름을 만들 것이므로 먼저 insert 후 해야함 
				fileService.uploadFilesToS3(adminProductDto, new String[]{"images"}, adminProductDto.getIfprseq());
		return "redirect:/xdm/adminproduct/AdminProductXdmList"; 
		}
	
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmUpdt")
	public String AdminProductXdmUpdt(AdminProductDto adminProductDto) throws Exception {
		adminProductService.update(adminProductDto);
		
		// uaSeq로 파일이름을 만들 것이므로 먼저 insert 후 해야함 
		fileService.uploadFilesToS3(adminProductDto, new String[]{"images"}, adminProductDto.getIfprseq());
		return "redirect:/xdm/adminproduct/AdminProductXdmList"; 
		}
	@RequestMapping(value = "/xdm/adminproduct/AdminProductXdmUele")
	public String AdminProductXdmUele(AdminProductDto adminProductDto) {
		adminProductService.uelete(adminProductDto);
		return "redirect:/xdm/adminproduct/AdminProductXdmList"; 
		}
	//리뷰 저장
	@RequestMapping(value = "/xdm/usr/product/ProductUsrListInst", method = RequestMethod.POST)
	public String productUsrListInst(Model model, UserDto userDto,@ModelAttribute("vo") AdminProductVo vo, AdminProductDto adminProductDto) {

		int successCnt = userService.insertReview(userDto);
			
		if (successCnt > 0) {
			// 리뷰 리스트
			vo.setIfprseq(userDto.getProduce_seq());
		    model.addAttribute("items", userService.selectReview(vo));
		
		    // Thymeleaf fragment만 리턴
	        return "xdm/usr/product/ProductUsrList :: #reviewList";
		} else {
		    return "";
		}
	}
}
