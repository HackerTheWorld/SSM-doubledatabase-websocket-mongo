package com.cn.hnust.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSONObject;

import common.WebSocketSession;

@ServerEndpoint(value="/websocket/{pushid}/{sendid}")
public class TomcatWebSocket {
	
	private Logger logger = Logger.getLogger(TomcatWebSocket.class.getName());
	/*
	 * pushid 司机id
	 * sendid 客户id
	 * 
	 * 二选一如果为0,判断现在链接账号
	 * */
	@OnOpen
	public void onOpen(Session session,@PathParam(value = "pushid")String pushid,@PathParam(value = "sendid")String sendid) {
		if(!pushid.equals("0")) {
			WebSocketSession.driverMap.put(pushid, session);
		}else if(!sendid.equals("0")) {
			WebSocketSession.orderMap.put(sendid, session);
			for(String key: WebSocketSession.driverMap.keySet()) {
				JSONObject jsonObject = WebSocketSession.initPost.get(key);
				try {
					session.getBasicRemote().sendText(jsonObject.toJSONString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("push :"+pushid+"    sendid:"+sendid);
	}
	
	@OnClose
	public void onClose(@PathParam(value = "pushid")String pushid,@PathParam(value = "sendid")String sendid) {
		if(!pushid.equals("0")) {
			WebSocketSession.driverMap.remove(pushid);
			logger.info("pushid :"+pushid+" unline");
		}else if(!sendid.equals("0")) {
			WebSocketSession.orderMap.remove(sendid);
			logger.info("sendid :"+sendid+" unline");
		}
	}
	
	@OnMessage
	public void onMessage(String message,@PathParam(value = "pushid")String pushid) {
		JSONObject jsonObject = JSONObject.parseObject(message);
		WebSocketSession.initPost.put(pushid, jsonObject);
		String sendid = jsonObject.get("sendid").toString();
		try {
			Session orderSession = WebSocketSession.orderMap.get(sendid);
			if(orderSession!=null) {
				jsonObject.put("pushid", pushid);
				orderSession.getBasicRemote().sendText(jsonObject.toJSONString());
			}else {
				logger.info("order unline");
			}
		}catch(Exception e) {
				logger.info("error");
		}
		System.out.println(jsonObject.get("sendid")+":"+message);
	}

}
