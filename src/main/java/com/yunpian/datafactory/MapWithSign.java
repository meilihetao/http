package com.yunpian.datafactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import com.yunpian.http.Urlparams;
import com.yunpian.map.MapRemove;
import com.yunpian.map.SortMap;


//simboss生成签名和组装新的接口参数类
public class MapWithSign {
	public static Map<String, String> sign(Map<String, String> params){
		Map<String, String> pair = new HashMap<String, String>();
		Map<String, String> param1 = new HashMap<String, String>();
		String secret_value = params.get("secret");
		long epoch = 0;
	
		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dFormat.format(new Date());
		try {
			epoch = dFormat.parse(time).getTime()/1000;
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		pair.put("timestamp",epoch+"" );
				
		param1 = MapRemove.reMap(params, "secret");
		param1.put("timestamp", epoch+"");
		SortMap.sortMapByKey(param1);
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry :param1.entrySet()) {
			pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		String param = URLEncodedUtils.format(pairs, Urlparams.charset);		
		String orisign = param.concat(secret_value);	
		System.out.println(orisign);
		String sign = SHA256.getSHA256StrJava(orisign);
		pair.put("sign", sign);
			
		pair.putAll(params);
		SortMap.sortMapByKey(pair);
		return pair;
	}
}
