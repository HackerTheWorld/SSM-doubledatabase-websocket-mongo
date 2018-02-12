package com.cn.hnust.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.LoginEntityMapper;
import com.cn.hnust.pojo.LoginEntity;
import com.cn.hnust.service.ILoginService;

@Service("loginService")
public class LoginServiceImpl implements ILoginService{

	@Resource
	private LoginEntityMapper _loginentitymapper;
	

	public LoginEntity doLogin(String username, String password) {
		// TODO Auto-generated method stub
		
		return _loginentitymapper.selectByLogin(username, password);
	}


	public LoginEntity asToken(String token) {
		// TODO Auto-generated method stub
		return _loginentitymapper.selectBytoken(token);
	}


	public int changepassword(String password, String loginid) {
		// TODO Auto-generated method stub
		return _loginentitymapper.changePassword(password, loginid);
	}


	public int newuserinfo(String loginid, String userid) {
		// TODO Auto-generated method stub
		return _loginentitymapper.updateUserinfo(loginid, userid);
	}


	public int updateheadimg(String headimg, String userid) {
		// TODO Auto-generated method stub
		return _loginentitymapper.updateheadimg(headimg, userid);
	}


	public int insertToken(String token, int loginid) {
		// TODO Auto-generated method stub
		return _loginentitymapper.inserttoken(token, loginid);
	}


	public LoginEntity selectbytoken(String userid, String token) {
		// TODO Auto-generated method stub
		return _loginentitymapper.selectByToken(userid, token);
	}


	public LoginEntity selectheadimg(String userid) {
		// TODO Auto-generated method stub
		return _loginentitymapper.selectHeadImg(userid);
	}
		
}
