package com.cn.hnust.interceptor;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cn.hnust.filter.MyFilter;
import com.cn.hnust.pojo.LoginEntity;
import com.cn.hnust.service.ILoginService;

public class MyInterceptor implements HandlerInterceptor{
	
	private Logger logger = Logger.getLogger(MyInterceptor.class.getName());
	@Resource
	private ILoginService loginservice;
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object arg2) throws Exception {
		// TODO Auto-generated method stub
	
		if(req.getMethod().equals("POST")) {
			logger.info("post:"+req.getMethod());
			
		}else {
			logger.info("get:"+req.getRequestURI());
			if(req.getRequestURI().indexOf("/SSM/img/")!=-1) {
				return true;
			}
			return false;
		}
		if(req.getRequestURI().indexOf("/SSM/gps/")!=-1) {
			res.setHeader("Access-Control-Allow-Origin", "*"); 
			return true;
		}
		String token = req.getParameter("token");
		LoginEntity loginentity  = loginservice.asToken(token);
		if(loginentity == null) {
			logger.info("don't have this token");
			return false; 
		}else {
			res.setHeader("Access-Control-Allow-Origin", "*"); 
            res.setStatus(200);  
			return true;
		}
	}

}
