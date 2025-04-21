package com.asus.common.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.asus.module.user.UserDto;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	
//	회원가입 축하 메일
    public void sendMailWelcome(UserDto userDto) throws Exception{
    	
    	
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setTo(userDto.getUseremail()); 
    	mimeMessageHelper.setSubject("회원가입 축하합니다");
    	mimeMessageHelper.setText("축하합니다", true); 
    	
    	mimeMessageHelper.setFrom("jty2298@gmail.com", "FresgCart");
    	
    	javaMailSender.send(mimeMessage);
    	
    }



}
