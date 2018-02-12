package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.VersionEntityMapper;
import com.cn.hnust.pojo.VersionEntity;
import com.cn.hnust.service.IVersionService;

@Service("versionService")
public class CheckVersionServiceImpl implements IVersionService{

	@Resource
	private VersionEntityMapper _versionEntityMapper;
	
	public String checkVersion(String version) {
		// TODO Auto-generated method stub
		return _versionEntityMapper.selectVersion(version);
	}

}
