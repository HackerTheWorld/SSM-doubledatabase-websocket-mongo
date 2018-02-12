package com.cn.hnust.dao;

import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.User_infoEntity;

public interface User_infoEntityMapper {
    int deleteByPrimaryKey(Integer user_id);

	int insert(User_infoEntity record);

	int insertSelective(User_infoEntity record);

	User_infoEntity selectByPrimaryKey(Integer user_id);

	int updateByPrimaryKeySelective(User_infoEntity record);

	int updateByPrimaryKey(User_infoEntity record);

	User_infoEntity selectByuserid(@Param(value="user_id")String user_id);
	
	int updateimg(@Param(value="user_id")int user_id,@Param(value="imgtype")String imgtype,@Param(value="filename")String filename);
	
	int updateuserinfo(@Param(value = "user_id")int user_id,@Param(value = "type")String type,@Param(value = "text")String text);
	
	User_infoEntity selecttruename(@Param(value = "user_id")int user_id);
	
	User_infoEntity selectUserId(@Param(value = "truename")String truename);
}