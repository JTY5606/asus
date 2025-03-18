package com.asus.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asus.module.codegroup.CodeGroupDto;
import com.asus.module.codegroup.CodeGroupService;

@Controller
public class CodeController {
	
	@Autowired //인터페이스
	CodeService codeService;
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value = "/xdm/code/CodeXdmList")
	public String CodeXdmList(Model model,CodeVo vo) {
		
		vo.setParamsPaging(codeService.selectOneCount());
		int a = codeService.selectOneCount();
		model.addAttribute("list", codeService.selectList(vo));
		model.addAttribute("vo", vo);
		return "xdm/code/CodeXdmList"; 
		}

	@RequestMapping(value = "/xdm/code/CodeXdmForm")
	public String CodeXdmForm(Model model, CodeGroupDto codeGroupDto,CodeVo vo,CodeDto codeDto) {
		
		model.addAttribute("listCodeGroup" , codeGroupService.selectListWithoutPaging(codeGroupDto));
		
		System.out.println("codeDto.getCodegroupseq():" + codeDto.getCodegroupseq());
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
