package com.cn.hnust.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.AdverEntity;
import com.cn.hnust.service.IAdverService;

import common.Sendjson;

@Controller
@RequestMapping("adver")
public class AdverController {

	@Resource
	private IAdverService adverservice;
	private Logger logger = Logger.getLogger(AdverController.class.getName());
	
	@RequestMapping("getadverpath")
	@ResponseBody
	private String getadverpath() {
		Sendjson sendjson =new Sendjson();
		try {
			List<AdverEntity> list = adverservice.getAdverPath();
			List<Map> return_list = new ArrayList();
			List<AdverEntity> return_type_list = new ArrayList();
			Map map =new HashMap();
			for(AdverEntity str:list) {
				AdverEntity adv = new AdverEntity();
				AdverEntity adv1 = new AdverEntity();
				
				String s = Sendjson.ServiceIP+"mystatic/advertisement/"+str.getAdver_path();	
				Map map2 = new HashMap();
				map2.put("content", s);
				return_list.add(map2);
				
				String s1 = str.getType();
				adv1.setType(s1);
				return_type_list.add(adv1);
				
			}
			map.put("return_list", return_list);
			map.put("return_type_list", return_type_list);
			sendjson.setresParam(map);
			sendjson.setResCode(1);
			sendjson.setResNode("success");
		}catch(Exception e) {
			sendjson.setResNode(e.toString());
			logger.info(e.toString());
		}
		return sendjson.changetype().toJSONString();
	}
	
}
