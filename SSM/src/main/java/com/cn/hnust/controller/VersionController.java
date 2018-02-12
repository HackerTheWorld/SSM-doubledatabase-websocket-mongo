package com.cn.hnust.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.VersionEntity;
import com.cn.hnust.service.IVersionService;

import common.Sendjson;

@Controller
@RequestMapping("check")
public class VersionController {
	
	@Resource
	private IVersionService versionService;
	
	@RequestMapping("version")
	@ResponseBody
	public String version(@RequestParam("version")String version) {
		Sendjson sendjson = new Sendjson();
		try {
			String url = versionService.checkVersion(version);
			Map map = new HashMap();
			map.put("url",url);
		    sendjson.setresParam(map);
		    sendjson.setResCode(2);
		}catch(Exception e) {
			sendjson.setResCode(1);
			sendjson.setResNode(e.toString());
		}
		return sendjson.changetype().toJSONString();
	}
	
}
