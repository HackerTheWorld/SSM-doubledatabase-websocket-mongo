package com.cn.hnust.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.LoginEntity;
import com.cn.hnust.pojo.User_infoEntity;
import com.cn.hnust.service.ILoginService;
import com.cn.hnust.service.IUserinfoService;

import common.Sendjson;

@Controller
@RequestMapping("/userinfo")
public class UserinfoController {

	@Resource
	private IUserinfoService userinfoservice;
	@Resource
	private ILoginService loginservice;
	private Logger logger = Logger.getLogger(UserinfoController.class.getName());
	
	@RequestMapping(value="/getuserinfo",produces="text/plain;charset=UTF-8")
	@ResponseBody
	private String getuserinfo(HttpServletRequest req,@RequestParam("userid")String user_id) {
		Sendjson sendjson =new Sendjson();
		try {
			User_infoEntity user_infoentity = userinfoservice.getuserinfor(user_id);
			user_infoentity.setDriver_id(Sendjson.ServiceIP+"driver_id/"+user_infoentity.getDriver_id());
			user_infoentity.setCar_id(Sendjson.ServiceIP+"car_id/"+user_infoentity.getCar_id());
	
			Map map =new HashMap();
			String node = "";
			if(user_infoentity.equals(null)) {
				node = "faild";
			}else {
				map.put("userinfo", user_infoentity);
				sendjson.setResCode(1);
				node = "success";
			}
			sendjson.setresParam(map);			
			sendjson.setResNode(node);
			
		}catch(Exception e) {
			sendjson.setResNode(e.toString());
			logger.info(e.toString());
		}
		System.out.println(sendjson.changetype().toJSONString());
		return sendjson.changetype().toJSONString();
	}
	
	@RequestMapping("/createuserinfo")
	@ResponseBody
	private String createuserinfo(HttpServletRequest req,@RequestParam("loginid")String loginid,
			@RequestParam("truename")String truename,@RequestParam("carnumber")String carnumber,
			@RequestParam("phone")String phone,@RequestParam("username")String name,@RequestParam("address")String address) {
		Sendjson sendjson = new Sendjson();
		try {
			int f =userinfoservice.createuserinfo(truename, carnumber, phone, name, address);
			int f1 =loginservice.newuserinfo(loginid, String.valueOf(f));
			String node ="";
			if(f==0||f1==0) {
				node = "faild";
			}else {
				node ="success";
				sendjson.setResCode(1);
			}
			sendjson.setResNode(node);
		}catch(Exception e) {
			sendjson.setResNode(e.toString());
			logger.info(e.toString());
		}
		
		return sendjson.changetype().toJSONString();
	}
	
	@RequestMapping("/updateuserinfo")
	@ResponseBody
	private String updateuserinfo(HttpServletRequest req,@RequestParam("userid")String userid,
			@RequestParam("type")String type,@RequestParam("text")String text) {
		Sendjson sendjson = new Sendjson();
		userinfoservice.updateuserinfo(Integer.valueOf(userid), type, text);
		return null;
	}
	
	
}
