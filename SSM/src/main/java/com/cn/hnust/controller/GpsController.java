package com.cn.hnust.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.pojo.User_infoEntity;
import com.cn.hnust.service.IUserinfoService;
import com.cn.mongo.entity.GpsPointEntity;
import com.mongodb.BasicDBObject;

import common.Sendjson;

@Controller
@RequestMapping("/gps")
public class GpsController {
	
	@Autowired
    private MongoTemplate mongoTemplate;
	@Autowired
	private IUserinfoService userInfoService;
	
	@RequestMapping("/savegps")
	@ResponseBody
	private String saveGps(@RequestBody List<GpsPointEntity> pointList) {
		Sendjson sendjson = new Sendjson();
		try {
			mongoTemplate.insert(pointList,GpsPointEntity.class);
			sendjson.setResCode(1);
		}catch(Exception e) {
			sendjson.setResCode(0);
			sendjson.setResNode(e.toString());
		}
		System.out.println(sendjson.changetype().toJSONString());
		return sendjson.changetype().toJSONString();
	}
	
	@RequestMapping("/getgpspoint")
	@ResponseBody
	private List getGpsPoint(@RequestParam("starttime")String startTime,@RequestParam("endtime")String endTime,
			@RequestParam("drivername")String driverName) {
		User_infoEntity userid = userInfoService.getUserId(driverName);
		Query query = new Query();
		query.addCriteria(Criteria.where("time").gte(Long.valueOf(startTime)).lte(Long.valueOf(endTime)));
		List<GpsPointEntity> gpsList = mongoTemplate.find(query,GpsPointEntity.class);
		
		return gpsList;
	}
	
	@RequestMapping("/showtest")
	@ResponseBody
	private String showTest(HttpServletRequest res) {
		
		List<GpsPointEntity> gpsList = mongoTemplate.findAll(GpsPointEntity.class);
		for(GpsPointEntity gpsPointEntity:gpsList) {
			System.out.println(gpsPointEntity.getAddress()+" : latitude-"+gpsPointEntity.getLatitude()+" longitude-"+gpsPointEntity.getLongitude());
		}
		return null;
	}
}
