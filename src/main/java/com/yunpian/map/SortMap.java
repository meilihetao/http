package com.yunpian.map;


import java.util.Map;
import java.util.TreeMap;


//对map进行升序排序
public class SortMap {
	
	public static Map<String, String> sortMapByKey(Map<String,String> oriMap){
		if(oriMap ==null ||oriMap.isEmpty()) {
			return null;
		}
		Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
		sortMap.putAll(oriMap);
		return sortMap;	
	}
}


