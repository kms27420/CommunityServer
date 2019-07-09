package com.kms.communityserver.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kms.communityserver.model.account.AccountTO;
import com.kms.communityserver.service.LoginService;

@Controller
public class LoginCtrl {
	@Autowired private LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public Boolean login(HttpServletRequest request, @RequestBody AccountTO param) {
		return service.login(request, param);
	}
}
