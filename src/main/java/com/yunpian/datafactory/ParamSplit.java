package com.yunpian.datafactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.yunpian.http.Urlparams;
import com.yunpian.map.MapRemove;


//对于excel取出的接口参数拼接成form表单类型的方法
public class ParamSplit {
	public static String dosplit(Map<String, String> params, String key) {
		String param = "";
		Map<String, String> params1 = new HashMap<String, String>();
		if (key == null || key.isEmpty()) {
			if (params !=null) {
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				for (Entry<String, String> e:params.entrySet()) {
					pairs.add(new BasicNameValuePair(e.getKey(),e.getValue()));
				}
				param = URLEncodedUtils.format(pairs, Urlparams.charset);				
			}
		}else {
			    params1 = MapRemove.reMap(params, key);
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				for (Entry<String, String> e:params1.entrySet()) {
					pairs.add(new BasicNameValuePair(e.getKey(),e.getValue()));
				}
				param = URLEncodedUtils.format(pairs, Urlparams.charset);	
			}		
		
		return param;
		
	}

}
