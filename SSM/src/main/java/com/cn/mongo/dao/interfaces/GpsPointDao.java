package com.cn.mongo.dao.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cn.mongo.entity.GpsPointEntity;

@Transactional
public interface GpsPointDao {
	public List<GpsPointEntity> findGpsPoint(String driverName);
	public void addGpsPoint(GpsPointEntity gpsPointEntity);
	
}
