package com.asus.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asus.login.LoginService;

@Controller
public class CodeController {
	
	@Autowired //인터페이스
	CodeService codeService;
	
	@RequestMapping(value = "/xdm/code/CodeXdmList")
	public String CodeXdmList(Model model,CodeVo vo) {
		
		vo.setParamsPaging(codeService.selectOneCount());
		int a = codeService.selectOneCount();
		model.addAttribute("list", codeService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/code/CodeXdmList"; 
		}

	@RequestMapping(value = "/xdm/code/CodeXdmForm")
	public String CodeXdmForm() {
		
		
		return "xdm/code/CodeXdmForm"; 
		}
	
	@RequestMapping(value = "/xdm/code/CodeXdmInst")
	public String CodeXdmInst(CodeDto codeDto) {
		
		codeService.insert(codeDto);
		return "redirect:/xdm/code/CodeXdmList"; 
		}
	@RequestMapping(value = "/xdm/code/CodeXdmUele")
	public String CodeXdmUele(CodeDto codeDto) {
		
		codeService.uelete(codeDto);
		return "redirect:/xdm/code/CodeXdmList"; 
		}
	
}
