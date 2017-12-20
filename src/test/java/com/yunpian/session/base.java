package com.yunpian.session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;


import com.yunpian.datafactory.ParamSplit;
import com.yunpian.http.HttpClientUtil;


public class base{
	private static Logger logger = Logger.getLogger(base.class);
	
	@BeforeTest
	public static void getsession() {
		String destURLStr = "https://test-web.yunpian.com/component/login";
		URL destURL = null;
		URLConnection urlCon = null;
		HttpURLConnection httpUrlCon = null;
		PrintWriter out = null;
		BufferedReader in =null;		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		String JSESSIONID = "";
				
		try {
			destURL = new URL(destURLStr);
			urlCon = destURL.openConnection();
			httpUrlCon = (HttpURLConnection)urlCon;
			
			Map<String, String> param = new HashMap<String, String>();
			param.put("name", "18657161369");
			param.put("password", "hyj333666");
			String params = ParamSplit.dosplit(param, "");
			
			httpUrlCon.setRequestProperty("Accept", "application/json");
			httpUrlCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpUrlCon.setRequestProperty("connection", "Keep-Alive");
			httpUrlCon.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			 //发送POST请求必须设置如下两行
			httpUrlCon.setDoOutput(true);
			httpUrlCon.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			 out = new PrintWriter(httpUrlCon.getOutputStream());
			// 发送请求参数
			 out.print(params);
			// flush输出流的缓冲
			 out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			 in = new BufferedReader(new InputStreamReader(httpUrlCon.getInputStream()));
			 map = httpUrlCon.getHeaderFields();
			 
			 List<String> Cookie = map.get("Set-Cookie");
//			 String str1 = Cookie.get(0);
//			 String [] str2 = str1.split("=|;");
			
			 
//			 JSESSIONID = str2[1];
			 HttpClientUtil.setsession(Cookie.toString());
//			 System.out.println(JSESSIONID);
						 			
		}catch (Exception e) {
			 logger.error("发送 登陆 请求出现异常！"+e);
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
	}

}
