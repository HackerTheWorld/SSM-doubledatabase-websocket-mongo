package com.cn.hnust.dao;

import com.cn.hnust.pojo.VersionEntity;

public interface VersionEntityMapper {

	int deleteByPrimaryKey(Integer versionid);

	int insert(VersionEntity record);

	int insertSelective(VersionEntity record);

	VersionEntity selectByPrimaryKey(Integer versionid);

	int updateByPrimaryKeySelective(VersionEntity record);

	int updateByPrimaryKey(VersionEntity record);
	
	String selectVersion(String version);
}