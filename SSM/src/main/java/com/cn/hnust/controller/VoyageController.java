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

import com.cn.hnust.dao.VoyageEntityMapper;
import com.cn.hnust.pojo.VoyageEntity;
import com.cn.hnust.service.IVoyageService;

import common.Sendjson;

@Controller
@RequestMapping("/voyage")
public class VoyageController {
		
	@Resource
	private IVoyageService voyageservice;
	private Logger logger = Logger.getLogger(VoyageController.class.getName());
	
	@RequestMapping("/getvoyagebyid")
	@ResponseBody
	private String getVoyageByid(HttpServletRequest req,@RequestParam("voyageid")String voyage_id) {
		
		Sendjson sendjson = new Sendjson();
		
		try {

			VoyageEntity voyageentity = voyageservice.getVoyageEntity(voyage_id);
			Map map = new HashMap();
			String node = "";
			if(voyageentity.equals(null)) {
				node = "faild";
			}else {
				map.put("voyageentity", voyageentity);
				node = "success";
				sendjson.setResCode(1);
			}
			sendjson.setResNode(node);
			sendjson.setresParam(map);
		}catch(Exception e) {
			sendjson.setResNode(e.toString());
			logger.info(e.toString());
		}
		return sendjson.changetype().toJSONString();
		
	}
	
	
	@RequestMapping("/getpicurl")
	@ResponseBody
	private String getPicURL(HttpServletRequest req,@RequestParam("voyageid")String voyage_id) {
			Sendjson sendjson = new Sendjson();
			
			try{
				String picurl = voyageservice.getPicURL(voyage_id);
				Map map = new HashMap();
				String node = "";
				if(picurl.equals(null)||picurl.equals("null")) {
					node ="faild";
				}else {
					map.put("picurl", Sendjson.ServiceIP+"voyage/"+picurl);
					sendjson.setResCode(1);
					node = "success";
				}
				sendjson.setResNode(node);
				sendjson.setresParam(map);
			}catch(Exception e) {
				sendjson.setResNode(e.toString());
				logger.info(e.toString());
			}
			return sendjson.changetype().toJSONString();
	}
	
	
	
	
	
}
