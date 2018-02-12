package common;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

import com.alibaba.fastjson.JSONObject;

public class WebSocketSession {
	public static Map<String,Session> driverMap = new  HashMap<String,Session>();
	public static Map<String,Session> orderMap = new HashMap<String,Session>();
	public static Map<String,JSONObject> initPost = new HashMap<String,JSONObject>();
}
