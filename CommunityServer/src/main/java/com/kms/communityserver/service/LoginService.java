package com.kms.communityserver.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.kms.communityserver.dao.AccountDAO;
import com.kms.communityserver.model.account.AccountTO;

@Service
public class LoginService {
	@Resource(name="accountMapper") 
	private AccountDAO accountDAO;
	
	public Boolean login(HttpServletRequest request, AccountTO param) {
		 Boolean isSuccess = accountDAO.isAccountValid(param);
		 request.getSession().setAttribute("loginStatus", isSuccess);
		 return isSuccess;
	}
}
