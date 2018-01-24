package com.yunpian.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunpian.datafactory.ParamSplit;




public class HttpClientUtil {
	private static Logger logger = Logger.getLogger(HttpClientUtil.class);
	private static String session = "";
	
	public static String getsession() {
		return session;
	}
	public static void setsession(String session) {
		HttpClientUtil.session = session;
	}

	public static String dopost(String url, Map<String, String> params,String key,String key1) {
		 PrintWriter out = null;
		 BufferedReader in =null;
		 String result ="";
		 String param = null;
		 
		 
        if (key1 !=null&& !key1.isEmpty()) {
            param = ParamSplit.dosplit(params,key);
        }else {
        	    JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(params));
    		    param = JSON.toJSONString(itemJSONObj);
		}
        
//        System.out.println(param);
		


		 try {
			 URL realurl = new URL(url);
			// 打开和URL之间的连接
			 URLConnection connection = realurl.openConnection();
			// 设置通用的请求属性
			 connection.setRequestProperty("Accept", "application/json");
			 if(key1 !=null&& !key1.isEmpty()) {
				 connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			 }else {
				 connection.setRequestProperty("Content-Type", "application/json");
			}
			 
			 connection.setRequestProperty("connection", "Keep-Alive");
			 connection.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			 connection.setRequestProperty("Cookie", getsession());
			 
			 
			 //发送POST请求必须设置如下两行
			 connection.setDoOutput(true);
			 connection.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			 out = new PrintWriter(connection.getOutputStream());
			// 发送请求参数
			 out.print(param);
			// flush输出流的缓冲
			 out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			 in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			 String line;
			 while((line =in.readLine())!=null) {
				 result += line;
			 }			 
		 }catch (Exception e) {
			 logger.error("发送 POST 请求出现异常！"+e);
			 e.printStackTrace();
		}
		 finally {
			 try {
				 if (out != null) {
					 out.close();
				 }
				 if (in != null) {
					 in.close();
				 }
			 }catch(IOException ex) {
				 ex.printStackTrace();
			 }
		 }		 
		 return result;
	}	
	
	public static String doget(String url, Map<String, String> params,String key) {
		 PrintWriter out = null;
		 BufferedReader in =null;
		 String result ="";
		 String param = null;
		
		 param = ParamSplit.dosplit(params,key);
		 
//		 System.out.println(param);
		 
		 try {
			 String  urlstring = url + "?" + param;
//			 System.out.println(urlstring);
			 URL realUrl = new URL(urlstring);
			 URLConnection connection = realUrl.openConnection();
			 
			 
			 connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
			 connection.setRequestProperty("accept", "*/*");
			 connection.setRequestProperty("connection", "Keep-Alive");
			 connection.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			 connection.setRequestProperty("Cookie", getsession());
			 
			 connection.connect();
			 
			 in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			 String line;
			 while((line =in.readLine())!=null) {
				 result += line;
			 }			 
		 }catch (Exception e) {
			 logger.error("发送 get 请求出现异常！"+e);
			 e.printStackTrace();
		}
		 finally {
			 try {
				 if (out != null) {
					 out.close();
				 }
				 if (in != null) {
					 in.close();
				 }
			 }catch(IOException ex) {
				 ex.printStackTrace();
			 }
		 }		 
		 return result;			 		 
	 }	
}
