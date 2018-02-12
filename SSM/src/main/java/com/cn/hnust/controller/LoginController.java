package com.cn.hnust.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.LoginEntity;
import com.cn.hnust.pojo.User_infoEntity;
import com.cn.hnust.service.ILoginService;
import com.cn.hnust.service.IUserinfoService;

import common.Sendjson;
import common.UploadFile;

@Controller
@RequestMapping("/login")
public class LoginController {
		
	@Resource
	private ILoginService loginservice;
	@Resource
	private IUserinfoService userInfoService;
	Logger logger = Logger.getLogger(LoginController.class.getName());
	
	@RequestMapping("/dologin")
	@ResponseBody
	private String tologin(HttpServletRequest req,@RequestParam("username") String username,
			@RequestParam("password") String password) {
		Sendjson sendjson = new Sendjson();
		try {
			LoginEntity loginentity  = loginservice.doLogin(username,password);
			Map map = new HashMap();
			String node = "";
			if(loginentity.equals(null)) {
				node = "wrong password";
			}else {
				String token = UUID.randomUUID().toString().replaceAll("-", "");
				loginservice.insertToken(token, loginentity.getLogin_ID());
				loginentity.setToken(token);
				loginentity.setHeadimg(Sendjson.ServiceIP+"head/"+loginentity.getHeadimg());
				User_infoEntity userInfo = userInfoService.userTrueName(loginentity.getUser_id());
				map.put("loginentity", loginentity);
				map.put("userinfoentity", userInfo);
				node ="success";
			}
			sendjson.setresParam(map);
			sendjson.setResCode(1);
			sendjson.setResNode(node);
		}catch(Exception e) {
			sendjson.setResNode(e.toString());
			logger.info(e.toString());
		}
		System.out.println(sendjson.changetype().toJSONString());
		return sendjson.changetype().toJSONString();
	}
	
	@RequestMapping("/aslogin")
	@ResponseBody
	private String aslogin(HttpServletRequest req,@RequestParam("user_id")String userid,@RequestParam("token")String token) {
		Sendjson sendjson = new Sendjson();

		try {
			LoginEntity loginentity = loginservice.selectbytoken(userid, token);
			if(!loginentity.equals(null)) {
				sendjson.setResNode("success");
				sendjson.setResCode(1);
			}else {
				sendjson.setResNode("faile");
				sendjson.setResCode(0);
			}
			
		}catch(Exception e) {
			sendjson.setResNode("faile");
			sendjson.setResCode(0);
		}
		return sendjson.changetype().toJSONString();
	}
	
	@RequestMapping("/changepassword")
	@ResponseBody
	private String changepassword(HttpServletRequest req,@RequestParam("loginid") String loginid,
			@RequestParam("password")String password) {
		Sendjson sendjson = new Sendjson();
		try {
			int f= loginservice.changepassword(password, loginid);
			if(f==0) {
				sendjson.setResNode("don't have this loginid");
			}else {
				sendjson.setResNode("success");
				sendjson.setResCode(1);
			}
		}catch(Exception e) {
			logger.info(e.toString());
			sendjson.setResNode(e.toString());
		}
		return sendjson.changetype().toJSONString();
	}
	
	@RequestMapping("/headimg")
	@ResponseBody
	private String getheadimg(HttpServletRequest req,@RequestParam("userid")String userid) {
		Sendjson sendjson =new Sendjson();
		try {
			
		}catch(Exception e) {
			logger.info(e.toString());
			sendjson.setResNode(e.toString());
		}
		return sendjson.changetype().toJSONString();
	}
}
