package com.cn.hnust.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.User_infoEntityMapper;
import com.cn.hnust.pojo.User_infoEntity;
import com.cn.hnust.service.IUserinfoService;

@Service("userinfoservice")
public class UserinfoServiceImpl implements IUserinfoService{

	@Resource
	private User_infoEntityMapper _user_infoentitymapper;
	
	
	public User_infoEntity getuserinfor(String user_id) {
		// TODO Auto-generated method stub
		User_infoEntity user_infoentity = _user_infoentitymapper.selectByuserid(user_id);
		return user_infoentity;
	}

	public int createuserinfo( String truename, String carnumber, String phone, String name,
			String address) {
		// TODO Auto-generated method stub
		User_infoEntity user_infoentity = new User_infoEntity();
		user_infoentity.setTruename(truename);
		user_infoentity.setCarnumber(carnumber);
		user_infoentity.setPhone(phone);
		user_infoentity.setAddress(address);
		user_infoentity.setName(name);
		
		_user_infoentitymapper.insertSelective(user_infoentity);
		return user_infoentity.getUser_id();
	}

	public int updateimg(int user_id, String imgtype, String filename) {
		// TODO Auto-generated method stub
		int i = _user_infoentitymapper.updateimg(user_id, imgtype, filename);
		return i;
	}

	public int updateuserinfo(int user_id, String type, String text) {
		// TODO Auto-generated method stub
		int i = _user_infoentitymapper.updateuserinfo(user_id, type, text);
		return i;
	}

	public User_infoEntity userTrueName(int user_id) {
		// TODO Auto-generated method stub
		User_infoEntity user_info = _user_infoentitymapper.selecttruename(user_id);
		return user_info;
	}

	public User_infoEntity getUserId(String truename) {
		// TODO Auto-generated method stub
		User_infoEntity userid = _user_infoentitymapper.selectUserId(truename);
		return userid;
	}

}
