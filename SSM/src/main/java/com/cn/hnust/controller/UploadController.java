package com.cn.hnust.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.service.ILoginService;
import com.cn.hnust.service.IUserinfoService;

import common.Sendjson;
import common.UploadFile;

@Controller
@RequestMapping("upload")
public class UploadController {
	
	@Resource
	private IUserinfoService userinfoservice;
	
	@Resource
	private ILoginService loginservice;
	
	@RequestMapping("/upfile")
	@ResponseBody
	private String upload(HttpServletRequest request) {
		String imgtype = request.getParameter("imgtype");
		String user_id = request.getParameter("user_id");
		List filename = UploadFile.upload(request);
		Sendjson sendjson =new Sendjson();
		try {
			if(imgtype.equals("head")) {
				loginservice.updateheadimg(filename.get(0).toString(), user_id);
			}else {
				userinfoservice.updateimg(Integer.valueOf(user_id), imgtype, filename.get(0).toString());
			}
			sendjson.setResCode(1);
			sendjson.setResNode("success");
		}catch(Exception e) {
			sendjson.setResCode(0);
			sendjson.setResNode(e.toString());
		}
		return sendjson.changetype().toJSONString();
	}
	
}
