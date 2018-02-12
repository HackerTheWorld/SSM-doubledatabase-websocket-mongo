package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.VoyageEntity;

public interface IVoyageService {

	public VoyageEntity getVoyageEntity(String voyage_id);
	
	public String getPicURL(String voyage_id);
}
