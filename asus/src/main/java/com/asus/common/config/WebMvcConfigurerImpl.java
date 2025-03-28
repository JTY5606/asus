package com.asus.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.asus.interceqtor.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginSessionInterceptor())
			.addPathPatterns("/*/*/*Xdm*")
			.excludePathPatterns(
						"/xdm/index/IndexXdmList",
						"/xdm/adminlogin/AdminLoginXdmList",
						"/signoutXdmProc",
						"/signinXdmProc",
						"/xdm/login/LoginXdmList"
						
						);
	}

	
}
