package com.cn.hnust.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.OlderEntity;
import com.cn.hnust.pojo.VoyageEntity;
import com.cn.hnust.service.IOlderService;
import com.cn.hnust.service.IVoyageService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.jiguang.JPush;

import common.Sendjson;

@Controller
@RequestMapping("/order")
public class OlderController<T> {
	
	@Resource
	private IOlderService olderservice;
	@Resource
	private IVoyageService voyageservice;
	
	private Logger logger = Logger.getLogger(OlderController.class.getName());
	
	@RequestMapping(value="/getorderlist",produces="text/plain;charset=UTF-8")
	@ResponseBody
    private String getOrderList(HttpServletRequest req,@RequestParam("userid")String user_id,
    		@RequestParam("type")String type,@RequestParam("page")String page) {
		Sendjson sendjson =new Sendjson();
		String f= type;
		int count = Integer.valueOf(page)*7;
		try {
			List<OlderEntity> list = olderservice.getOrderList(user_id,f,type,count);
			String node = "";
			if(list.isEmpty()) {
				node = "falid";
			}else {
				node = "success";
				sendjson.setResCode(1);
			}
			
			sendjson.setResNode(node);
			sendjson.setJsonarray(list);
		}catch(Exception e) {
			sendjson.setResNode(e.toString());
			logger.info(e.toString());
		}
	 return sendjson.changetype().toJSONString();
    }

	@RequestMapping(value="/getorderlistbyvoyageid",produces="text/plain;charset=UTF-8")
	@ResponseBody
	private String getOrderListByVoyageid(HttpServletRequest req,@RequestParam("userid")String user_id,
			@RequestParam("voyageid")String voyage_id,@RequestParam("page")String page) {
			Sendjson sendjson = new Sendjson();
			int count = Integer.valueOf(page)*5;
			try {
				Map map = new HashMap();
				List<OlderEntity> list = olderservice.getOrderListByVoyageid(voyage_id, user_id,count);
				VoyageEntity  voyageentity = voyageservice.getVoyageEntity(voyage_id);
				String node ="";
				if(voyageentity.equals(null)||list.isEmpty()) {
					node = "falid";
				}else {
					map.put("voyageentity", voyageentity);
					node = "success";
					sendjson.setResCode(1);
				}
				
				sendjson.setresParam(map);
				sendjson.setJsonarray(list);
			}catch(Exception e) {
				sendjson.setResNode(e.toString());
				logger.info(e.toString());
			}
			return sendjson.changetype().toJSONString();
	}
	
	@RequestMapping("/testpush")
	@ResponseBody
	private String testpush(HttpServletRequest req) {
		Sendjson sendjson = new Sendjson();
		
		String stralias = req.getParameter("alias");
		stralias = stralias.substring(1, stralias.length()-1);
		List alias = Arrays.asList(stralias.split(","));
		String mess = req.getParameter("mess");
		String title = req.getParameter("title");
		String cid = UUID.randomUUID().toString();
		String param = req.getParameter("param");
		JSONObject jsonobject = JSONObject.parseObject(param);
		
		JPush.sendPostRequest(alias, mess, title, cid, jsonobject);
		
		sendjson.setResCode(1);
		return sendjson.changetype().toJSONString();
	}
	
}
