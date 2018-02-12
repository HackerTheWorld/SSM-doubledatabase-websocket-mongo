package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.VoyageEntityMapper;
import com.cn.hnust.pojo.VoyageEntity;
import com.cn.hnust.service.IVoyageService;

@Service("voyageservice")
public class VoyageServiceImpl implements IVoyageService{
	@Resource
	private VoyageEntityMapper _voyageentitymapper;

	public VoyageEntity getVoyageEntity(String voyage_id) {
		// TODO Auto-generated method stub
		
		VoyageEntity voyageentity = _voyageentitymapper.selectByPrimaryKey(Integer.valueOf(voyage_id));
		return voyageentity;
	}

	public String getPicURL(String voyage_id) {
		// TODO Auto-generated method stub
		String picurl = _voyageentitymapper.selectPicURL(voyage_id);
		return picurl;
	}
	
	
}
