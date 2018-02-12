package com.cn.hnust.service;

import com.cn.hnust.pojo.LoginEntity;

public interface ILoginService {
	 public LoginEntity doLogin(String username,String password);
	 public int insertToken(String token,int loginid);
	 public LoginEntity asToken(String token);
	 public int changepassword(String password,String loginid);
	 public int newuserinfo(String loginid,String userid);
	 public int updateheadimg(String headimg,String userid);
	 public LoginEntity selectbytoken(String userid,String token);
	 public LoginEntity selectheadimg(String userid);
}
