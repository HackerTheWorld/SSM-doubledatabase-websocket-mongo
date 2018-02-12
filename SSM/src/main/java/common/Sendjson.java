package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Sendjson {
	public static final String ServiceIP =  "http://120.132.6.27/SSM/img/";
	private String resNode=null;
	private Map resParam = new HashMap();
	private int resCode = 0;
	private List jsonarray= new ArrayList();
	
	public Sendjson() {}
	
	public Sendjson(String resNode) {
		this.resNode = resNode;
	}
	
	public Sendjson(int resCode) {
		this.resCode = resCode;
	}
	
	public Sendjson(Map resParam) {
		this.resParam = resParam;
	}
	
	public List getJsonarray() {
		return jsonarray;
	}

	public void setJsonarray(List list) {
		this.jsonarray = list;
	}

	public Sendjson(String resNode,Map resParam) {
		this.resNode = resNode;
		this.resParam = resParam;
	}
	
	public Sendjson(int resCode,Map resParam) {
		this.resCode = resCode;
		this.resParam = resParam;
	}
	
	public Sendjson(String resNode,Map resParam,int resCode) {
		this.resNode = resNode;
		this.resParam = resParam;
		this.resCode = resCode;
	}
	
	public JSONObject changetype() {
		JSONObject jsonobject = new JSONObject();
		if(!jsonarray.isEmpty()||jsonarray.size()!=0)
			resParam.put("sendList", jsonarray);
		jsonobject.put("resNode", resNode);
		jsonobject.put("resParam", resParam);
		jsonobject.put("resCode", resCode);
		return jsonobject;
	}

	public String getResNode() {
		return resNode;
	}

	public void setResNode(String resNode) {
		this.resNode = resNode;
	}

	public int getResCode() {
		return resCode;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	public Map getresParam() {
		return resParam;
	}

	public void setresParam(Map resParam) {
		this.resParam = resParam;
	}
	

}
