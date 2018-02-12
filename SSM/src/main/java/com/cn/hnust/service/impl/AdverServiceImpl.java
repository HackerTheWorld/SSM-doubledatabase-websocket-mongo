package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.AdverEntityMapper;
import com.cn.hnust.pojo.AdverEntity;
import com.cn.hnust.service.IAdverService;

@Service("adverservice")
public class AdverServiceImpl implements IAdverService{
	@Resource
	private AdverEntityMapper _adverentitymapper;

	public List<AdverEntity> getAdverPath() {
		// TODO Auto-generated method stub
		return _adverentitymapper.selectListPath();
	}
	
}
