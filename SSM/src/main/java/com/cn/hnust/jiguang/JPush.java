package com.cn.hnust.jiguang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject; 

public class JPush {
    private static final String masterSecret = "5f767e414ce5045ddd797616";
    private static final String appKey = "3dcfbb83709660317d3f037b";
    private static final String pushUrl = "https://api.jpush.cn/v3/push";     
   
    /**
     * 组装极光推送专用json串
     * @param alias
     * @param alert
     * @return json
     */
    public static JSONObject generateJson(List alias,String mess,String title,String cid,JSONObject json){
       
       JSONObject jsonaudience = new JSONObject();
       jsonaudience.put("alias", alias);
       
       JSONObject jsonmess = new JSONObject();
       jsonmess.put("msg_content", mess);
       jsonmess.put("title", title);
       //jsonmess.put("content_type", 0);
       jsonmess.put("extras", json);
       
       JSONObject jsonobject = new JSONObject();
       //jsonobject.put("cid", appKey+"-"+cid);
       jsonobject.put("platform", "all");
       jsonobject.put("audience", jsonaudience);
       jsonobject.put("message", jsonmess);
       
       System.out.println(jsonobject.toJSONString());
       return jsonobject;
    }
    
    /**
     * 发送Post请求（json格式）
     * @param reqURL
     * @param data
     * @param encodeCharset
     * @param authorization
     * @return result
     */
   
    public static void sendPostRequest(List alias,String mess,String title,String cid,JSONObject json){
    	 PrintWriter out = null;
         BufferedReader in = null;
         String appkey = encryptBASE64();
         //String Authorization = "Basic "+appKey+":"+masterSecret;
        try {
        	 HttpClient httpClient = new DefaultHttpClient();
             // 设置超时时间
             httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
             httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
                 
        	HttpPost post = new HttpPost(pushUrl);
        	post.setHeader("Authorization", appkey); 
        	post.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");     
        	for(Header head:post.getAllHeaders()) {
        		System.out.println(head.getName()+":"+head.getValue());
        	}
        	 // 构建消息实体
            StringEntity entity = new StringEntity(generateJson(alias,mess,title,cid,json).toString(),"utf-8");
            entity.setContentEncoding("utf-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json;charset=utf-8");
            post.setEntity(entity);
           
            HttpResponse response = httpClient.execute(post);
          //  printResponse(response);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("return :"+statusCode);
        } catch (Exception e) {
            System.out.println("请求通信[" + pushUrl + "]时偶遇异常,堆栈轨迹如下"+e);  
        } finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
     /** 
　　　　* BASE64加密工具
　　　　*/
     public static String encryptBASE64() {
    	 String str = appKey+":"+masterSecret;
    	 String encoded = null;
		try {
			encoded = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return  "Basic "+encoded;  
     }
     
     /**
      * 
      */
        public static void printResponse(HttpResponse httpResponse)  
       
            throws ParseException, IOException {  
        // 获取响应消息实体  
        HttpEntity entity = httpResponse.getEntity();  
        // 响应状态  
        System.out.println("status:" + httpResponse.getStatusLine());  
        System.out.println("headers:");  
        HeaderIterator iterator = httpResponse.headerIterator();  
        while (iterator.hasNext()) {  
            System.out.println("\t" + iterator.next());  
        }  
        // 判断响应实体是否为空  
        if (entity != null) {  
            String responseString = EntityUtils.toString(entity);  
            System.out.println("response length:" + responseString.length());  
            System.out.println("response content:"  
                    + responseString.replace("\r\n", ""));  
        }  
    }  
   
      
}
