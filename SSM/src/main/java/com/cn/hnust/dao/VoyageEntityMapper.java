package com.cn.hnust.dao;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.VoyageEntity;

public interface VoyageEntityMapper {
    int deleteByPrimaryKey(Integer voyage_id);

	int insert(VoyageEntity record);

	int insertSelective(VoyageEntity record);

	VoyageEntity selectByPrimaryKey(Integer voyage_id);

	int updateByPrimaryKeySelective(VoyageEntity record);

	int updateByPrimaryKey(VoyageEntity record);

	String selectPicURL(@Param(value = "voyage_id")String voyage_id);
  
}