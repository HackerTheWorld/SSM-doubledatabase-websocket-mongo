package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.OlderEntityMapper;
import com.cn.hnust.pojo.OlderEntity;
import com.cn.hnust.pojo.VoyageEntity;
import com.cn.hnust.service.IOlderService;

@Service("olderService")
public class OlderServiceImpl implements IOlderService{

	@Resource
	private OlderEntityMapper _olderentitymapper;
	
	public List<OlderEntity> getOrderList(String user_id,String f,String type,int count) {
		// TODO Auto-generated method stub
		List<OlderEntity> list = _olderentitymapper.selectOlderByuserid(user_id,f,type,count);
		return list;
	}

	public List<OlderEntity> getOrderListByVoyageid(String voyage_id, String user_id,int count) {
		// TODO Auto-generated method stub
		List<OlderEntity> list = _olderentitymapper.selectOlderByVoyageid(voyage_id,user_id,count);
		return list;
	}

}
