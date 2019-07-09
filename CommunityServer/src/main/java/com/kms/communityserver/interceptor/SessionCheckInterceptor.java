package com.kms.communityserver.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		boolean isLogined =  request.getSession().getAttribute("loginStatus") instanceof Boolean 
//				&& (Boolean)request.getSession().getAttribute("loginStatus");
//		if(!isLogined) {
//			response.setStatus(401);
//			OutputStream o = (OutputStream)response.getOutputStream();
//			o.write("There is no login session.".getBytes("UTF-8"));
//			o.close();
//		}
//		return isLogined;
		System.out.println(request.getHeader("Cookie"));
		if(request.getSession().getAttribute("test")==null)	request.getSession().setAttribute("test", "testing");
		return true;
	}
	
}
