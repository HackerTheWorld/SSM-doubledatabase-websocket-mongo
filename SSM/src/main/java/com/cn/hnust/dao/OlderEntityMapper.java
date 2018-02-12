package com.cn.hnust.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.OlderEntity;

public interface OlderEntityMapper {
    int deleteByPrimaryKey(Integer kuaidi_id);

	int insert(OlderEntity record);

	int insertSelective(OlderEntity record);

	OlderEntity selectByPrimaryKey(Integer kuaidi_id);

	int updateByPrimaryKeySelective(OlderEntity record);

	int updateByPrimaryKey(OlderEntity record);

	List<OlderEntity> selectOlderByuserid(@Param(value = "user_id")String user_id,@Param(value = "f")String f,
			@Param(value = "type")String type,@Param(value="count")int count);
    
    List<OlderEntity> selectOlderByVoyageid(@Param(value = "voyage_id")String voyage_id,
    		@Param(value = "user_id")String user_id,@Param(value="count")int count);
}