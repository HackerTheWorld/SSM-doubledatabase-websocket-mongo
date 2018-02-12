package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.pojo.OlderEntity;
import com.cn.hnust.pojo.VoyageEntity;

public interface IOlderService {
		public List<OlderEntity> getOrderList(String user_id,String f,String type,int count);
		
		public List<OlderEntity> getOrderListByVoyageid(String voyage_id,String user_id,int count);
}
