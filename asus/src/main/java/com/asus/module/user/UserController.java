package com.asus.module.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/xdm/user/UserXdmList")
	public String UserXdmList(Model model,@ModelAttribute("vo")UserVo vo) {
		vo.setParamsPaging(userService.selectOneCount(vo));
		
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", userService.selectList(vo));
		}
		
		return "xdm/user/UserXdmList";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/signinXdmProc")
	public Map<String, Object> signinXdmProc(UserDto userDto,HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		UserDto che = userService.selectSigin(userDto);
		
		if(che != null) {
			
			httpSession.setAttribute("sessSeqXdm", che.getUserseq());
			httpSession.setAttribute("sessIdXdm", che.getUserid());
			httpSession.setAttribute("sessNameXdm", che.getUsername());
			returnMap.put("rt", "success");
		}else {
			returnMap.put("rt", false);
		}
		return returnMap;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(UserDto userDto,HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
		return returnMap;
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/signupUsrProc")
	public Map<String, Object> signupUsrProc(UserDto userDto,HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		UserDto che = userService.selectSigup(userDto);
		
		if(che != null) {
			
			httpSession.setAttribute("sessIdXdm", che.getUserid());
			httpSession.setAttribute("sessEmailXdm", che.getUseremail());
			returnMap.put("rt", "success");
		}else {
			returnMap.put("rt", false);
		}
		return returnMap;
		
	}
	@RequestMapping(value = "/xdm/user/UserXdmForm")
	public String userXdmForm(@ModelAttribute("vo") UserVo vo, Model model) throws Exception{
		System.out.println(vo.getUserseq());
		if (vo.getUserseq().equals("0") || vo.getUserseq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", userService.selectOne(vo));
//			model.addAttribute("list", codeService.selectList(cvo));
		}
		return "xdm/user/UserXdmForm";
	}
	
	@RequestMapping(value = "/xdm/usr/signup/UserUsrInst")
	public String UserUsrInst(UserDto userDto) {
		
		userService.insert(userDto);
		return "xdm/usr/index/IndexUsrList"; 
		}
	
	
	
	@RequestMapping(value = "/xdm/user/UserXdmView")
	public String UserXdmView(Model model,UserVo vo) {
		
		model.addAttribute("item", userService.selectOne(vo));
		return "xdm/user/UserXdmView"; 
		}
//	@RequestMapping(value = "/signinUsrForm")
//	public String signinUsrForm(UserVo vo,HttpSession httpSession) {
		
//		if(UtilCookie.getValueUsr(Constats.COOKIE_SEQ_NAME_USR) != null) {
			//auto login
//			if(httpSession.getAttribute("sessSeqUsr") == null) {
			
//				vo.setUserseq(UtilCookie.getValueUsr(Constants.COOKIT_SEQ_NAME_USR));
			
//				UserDto rtMember = userService.selectOne(vo);
			
	//			httpSession.setMaxInactiveInterval(60 * Constants.SESSION_MINUTE_XDM); // 60second * 30 = 30minute
//				httpSession.setAttribute("sessSeqXdm", rtMember.getUserseq());
//				httpSession.setAttribute("sessIdXdm", rtMember.getUserid());
//				httpSession.setAttribute("sessNameXdm", rtMember.getUsername());
//			} else {
				//by pass
//			}return "redirect:/xdm/adminlogin/AdminLoginXdmList";
		
		
//		}else {
//			return "signinUsrForm";
//		}
//	}
}