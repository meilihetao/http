package com.yunpian.map;

import java.util.Comparator;

//map的比较器类扩展 
public class MapKeyComparator implements Comparator<String>{
	public  int compare(String str1, String str2) {
		return str1.compareTo(str2);
	}
}
