package com.asus.module.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asus.common.mail.MailService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	
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
			if(matchesBcrypt(userDto.getUserpassword(), che.getUserpassword(), 10)) {
				
			
			httpSession.setAttribute("sessSeqXdm", che.getUserseq());
			httpSession.setAttribute("sessIdXdm", che.getUserid());
			httpSession.setAttribute("sessNameXdm", che.getUsername());
			returnMap.put("rt", "success");
			}else {
				returnMap.put("rt", false);
			}
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
		
		int checkid = userService.selectTwoCount(userDto);
		if(checkid == 0) {
			userDto.setUserpassword(encodeBcrypt(userDto.getUserpassword(),10));
			
			int signup = userService.insert(userDto);
			if(signup == 1) {
				returnMap.put("rt", "success");
				new Thread() {
					public void run() {
						try {
							mailService.sendMailWelcome(userDto);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}.start();
			}else {
				returnMap.put("rt", "fail");
			}
		}else{
			returnMap.put("rt", "fail_id");
		}
	return returnMap;
		
	}
	@RequestMapping(value = "/xdm/user/UserXdmForm")
	public String userXdmForm(@ModelAttribute("vo") UserVo vo, Model model) throws Exception{
		if (vo.getUserseq().equals("0") || vo.getUserseq().equals("")) {
//			insert mode
		} else {
//			update mode
			model.addAttribute("item", userService.selectOne(vo));
//			model.addAttribute("list", codeService.selectList(cvo));
		}
		return "xdm/user/UserXdmForm";
	}
	
//	@RequestMapping(value = "/xdm/usr/signup/UserUsrInst")
//	public String UserUsrInst(UserDto userDto) {
//		
//		userDto.setUserpassword(encodeBcrypt(userDto.getUserpassword(),10));
//		
//		userService.insert(userDto);
//		return "xdm/usr/index/IndexUsrList"; 
//		}
	
	
	
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
	
	@RequestMapping(value = "/xdm/usr/mypage/MyPageUsrList")
	public String MyPageUsrList(Model model,@ModelAttribute("vo")UserVo vo,HttpSession httpSession,UserDto userDto) {
		//로그인하고 seq를 불러오는 함수
		vo.setUserseq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		
		
		model.addAttribute("item", userService.selectOne(vo));
		return "xdm/usr/mypage/MyPageUsrList";
	}
	@RequestMapping(value = "/xdm/usr/mypage/PasswordChageUsrList")
	public String PasswordChageUsrList(Model model,@ModelAttribute("vo")UserVo vo,HttpSession httpSession) {
		//로그인하고 seq를 불러오는 함수
		vo.setUserseq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		
		model.addAttribute("item", userService.selectOne(vo));
		return "xdm/usr/mypage/PasswordChageUsrList";
	}
	
	@RequestMapping(value = "/xdm/usr/mypage/IdDeleteUsrList")
	public String IdDeleteUsrList(Model model,@ModelAttribute("vo")UserVo vo,HttpSession httpSession) {
		//로그인하고 seq를 불러오는 함수
		vo.setUserseq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		
		model.addAttribute("item", userService.selectOne(vo));
		return "xdm/usr/mypage/IdDeleteUsrList";
	}
	@RequestMapping(value = "/xdm/usr/mypage/AddressChangeUsrList")
	public String AddressChangeUsrList(Model model,@ModelAttribute("vo")UserVo vo,HttpSession httpSession) {
		//로그인하고 seq를 불러오는 함수
		vo.setUserseq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		
		model.addAttribute("item", userService.selectOne(vo));
		return "xdm/usr/mypage/AddressChangeUsrList";
	}
	
	@RequestMapping(value = "/xdm/usr/mypage/AddressChangeCopyUsrList")
	public String AddressChangeCopyUsrList(Model model,@ModelAttribute("vo")UserVo vo,HttpSession httpSession) {
		//로그인하고 seq를 불러오는 함수
		vo.setUserseq(String.valueOf(httpSession.getAttribute("sessSeqXdm")));
		
		model.addAttribute("item", userService.selectOne(vo));
		return "xdm/usr/mypage/AddressChangeCopyUsrList";
	}
	
	@RequestMapping(value = "/xdm/usr/mypage/MyPageChangeUpdt")
	public String MyPageChangeUpdt(UserDto userDto) {
		
		userService.update(userDto);
		return "redirect:/xdm/usr/mypage/MyPageUsrList";
	}
	
	//비밀번호 변경
	@ResponseBody
	@RequestMapping(value = "/xdm/usr/mypage/PasswordUpdt")
	public Map<String, Object> PasswordUpdt(UserDto userDto,@RequestParam(value="usernewpassword") String usernewpassword) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		UserDto dto =userService.passwordcheck(userDto);
		if(dto == null) {
			returnMap.put("rt", "fail");
		}else {
			//입력한 비밀번호와 dto에 있는 비밀번호가 맞는지 확인
			if(matchesBcrypt(userDto.getUserpassword(), dto.getUserpassword(), 10)) {
				System.out.println("asdfasdfasdfasdf");
				userDto.setUserpassword(encodeBcrypt(usernewpassword, 10));
				int suc =userService.updatepassword(userDto);
				if(suc == 1) {
					returnMap.put("rt","success");
				}else {
					returnMap.put("rt","fail");
				}
			}else {
				System.out.println("asdfasdf15515151");
				returnMap.put("rt", "fail_pwd");
			}
		}
		return returnMap;
		
	}
	
	@RequestMapping(value = "/xdm/usr/mypage/IdUeleteUsrList")
	public String IdUeleteUsrList(UserDto userDto) {
		
		userService.uelete(userDto);
		
		return "redirect:/xdm/usr/mypage/MyPageUsrList";
	}
}