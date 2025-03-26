package com.asus.module.codegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asus.module.code.CodeService;
import com.asus.module.code.CodeVo;


@Controller
public class CodeGroupController {
	@Autowired //인터페이스
	CodeGroupService codeGroupService;
	@Autowired
	CodeService codeService;
	
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmList")
	public String CodeGroupXdmList(@ModelAttribute("vo") CodeGroupVo vo,Model model, CodeGroupDto codeGroupDto) {

		vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", codeGroupService.selectList(vo));
		}
		return "xdm/codegroup/CodeGroupXdmList"; 
		}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmForm")
	public String CodeGroupXdmForm(@ModelAttribute("vo") CodeGroupVo vo,CodeVo cvo,Model model) {
		
		if (vo.getIfcgseq().equals("0") || vo.getIfcgseq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", codeGroupService.selectOne(vo));
//			model.addAttribute("list", codeService.selectList(cvo));
			System.out.println("update");
		}
		return "xdm/codegroup/CodeGroupXdmForm"; 
		}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmInst")
	public String CodeGroupXdmInst(CodeGroupDto codeGroupDto) {
		
		codeGroupService.insert(codeGroupDto);
		return "redirect:/xdm/codegroup/CodeGroupXdmList"; 
		}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmItem")
	public String CodeGroupXdmItem(Model model,CodeGroupDto codeGroupDto) {
		
		model.addAttribute("item", codeGroupService.selectItem(codeGroupDto));
		return "xdm/codegroup/CodeGroupXdmItem"; 
		}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmDele")
	public String CodeGroupXdmDele(CodeGroupDto codeGroupDto) {
		
		codeGroupService.delete(codeGroupDto);
		return "redirect:/xdm/codegroup/CodeGroupXdmList"; 
		}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmUpdt")
	public String CodeGroupXdmUpdt(CodeGroupDto codeGroupDto) {
		
		codeGroupService.update(codeGroupDto);
		return "redirect:/xdm/codegroup/CodeGroupXdmList"; 
		}
	@RequestMapping(value = "/xdm/codegroup/CodeGroupXdmUele")
	public String CodeGroupXdmUele(CodeGroupDto codeGroupDto) {
		
		codeGroupService.uelete(codeGroupDto);
		return "redirect:/xdm/codegroup/CodeGroupXdmList"; 
		}
	
}
