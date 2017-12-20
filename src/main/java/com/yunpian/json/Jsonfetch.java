package com.yunpian.json;


import org.apache.commons.lang3.StringEscapeUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

//json字符串的解析
public class Jsonfetch {
	public static String jsonstring(String jsonString,String key) {
		String value = "";
		if(jsonString.isEmpty() ||jsonString ==null) {
		JSONObject jsonObject = JSON.parseObject(jsonString);
		if (!jsonString.contains("data")) {
		   value = jsonObject.getString(key);
		}else {
		   String data = jsonObject.getString("data");
		   JSONArray jArray = JSON.parseArray(data);
		   value = jArray.getJSONObject(0).getString(key);
		}
		}else {
			value = "0";
		}
		return value;		
	}
	
	//string型json的解析
	public static String json_string(String jString,String key) {
		String value = "";
		String jString1 = StringEscapeUtils.unescapeJava(jString);
		String jString2 = jString1.substring(1, jString1.length()-1);
		JSONObject jObject = JSON.parseObject(jString2);
		value = jObject.getString(key);
		return value;
	}
	
	public static String json_string1(String jString,String key) {
		String value = "";		
		JSONObject jObject = JSON.parseObject(jString);
		value = jObject.getString(key);
		return value;
	}
		
	
	//list型的json的解析
	public static String json_array(String jString,String key,int i) {
		String value = "";
		JSONArray jArray = JSON.parseArray(jString);
		value = jArray.getJSONObject(i).getString(key);
		return value;
	}
}
