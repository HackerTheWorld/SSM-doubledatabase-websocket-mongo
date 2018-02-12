package com.cn.hnust.service;

import com.cn.hnust.pojo.User_infoEntity;

public interface IUserinfoService {
	public User_infoEntity getuserinfor(String user_id);
	public int createuserinfo(String truename,String carnumber,String phone,String name,String address);
	public int updateimg(int user_id,String imgtype,String filename);
	public int updateuserinfo(int user_id,String type,String text);
	public User_infoEntity userTrueName(int user_id);
	public User_infoEntity getUserId(String truename);
}
