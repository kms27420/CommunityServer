package com.kms.communityserver.interceptor;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kms.communityserver.model.response.ResponseTO;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		response.setHeader("Set-Cookie", "JSESSIONID=" + request.getSession().getId()+";\\s*");
		boolean isLogined =  request.getSession().getAttribute("loginStatus") instanceof Boolean 
				&& (Boolean)request.getSession().getAttribute("loginStatus");
		if(!isLogined) {
			OutputStream o = (OutputStream)response.getOutputStream();
			ResponseTO resData = new ResponseTO();
			resData.setCode("401");
			resData.setMessage("There is no login session.");
			o.write(JSONObject.toJSONString(resData.convertToMap()).getBytes("UTF-8"));
			o.flush();
			o.close();
		}
		return isLogined;
	}
}
