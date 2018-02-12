package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.pojo.AdverEntity;

public interface AdverEntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdverEntity record);

    int insertSelective(AdverEntity record);

    AdverEntity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdverEntity record);

    int updateByPrimaryKey(AdverEntity record);
    
    List<AdverEntity> selectListPath();
}