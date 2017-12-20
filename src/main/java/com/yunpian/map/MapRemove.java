package com.yunpian.map;


import java.util.Iterator;
import java.util.Map;

//移除指定key的map参数
public class MapRemove {
	public static Map<String, String> reMap(Map<String, String> params,String key1){
		Iterator iterator = params.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			if(key1.equals(key)) {
				iterator.remove();
				params.remove(key1);
			}			
		}
		return params;
	}
}
