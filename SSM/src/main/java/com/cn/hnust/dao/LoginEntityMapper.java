package com.cn.hnust.dao;



import org.apache.ibatis.annotations.Param;

import com.cn.hnust.pojo.LoginEntity;

public interface LoginEntityMapper {

	int deleteByPrimaryKey(Integer login_ID);

	int insert(LoginEntity record);

	int insertSelective(LoginEntity record);

	LoginEntity selectByPrimaryKey(Integer login_ID);

	int updateByPrimaryKeySelective(LoginEntity record);

	int updateByPrimaryKey(LoginEntity record);

	LoginEntity selectByLogin(String username,String password);

	LoginEntity selectBytoken(String token);
	
	int changePassword(String password,String loginid);
	
	int updateUserinfo(@Param(value="loginid")String loginid,@Param(value="userid")String userid);
	
	int updateheadimg(@Param(value="headimg")String headimg,@Param(value="userid")String userid);
	
	int inserttoken(@Param(value="token")String token,@Param(value="loginid")int loginid);
	
	LoginEntity selectByToken(@Param(value="userid")String userid,@Param(value="token")String token);
	
	LoginEntity selectHeadImg(@Param(value="userid")String userid);
}