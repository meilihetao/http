package com.yunpian.api;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.yunpian.excle.CaseHelper;
import com.yunpian.excle.CaseInfo;
import com.yunpian.excle.ReadExcel;
import com.yunpian.http.HttpClientUtil;
import com.yunpian.http.Urlparams;
import com.yunpian.json.Jsonfetch;
import com.yunpian.session.base;

public class smsN_record extends base{
	 protected String caseExcelPath ="src/test/resource/smsN_record.xlsx";
		
		@DataProvider(name = "dataInfo")
	    protected Object[][] dataInfo() throws IOException {
	        Object[][] myObj = null;
	        System.out.println(caseExcelPath);
	        List<Map<String, String>> list = ReadExcel.readXlxs(caseExcelPath);
	        myObj = CaseHelper.getObjArrByList(list);
	        return myObj;
		}
		
		@Test(dataProvider = "dataInfo")
			public void test_smsN_record(CaseInfo c) throws IOException{
	        String url = Urlparams.smsN_record; 
	        String response = HttpClientUtil.doget(url, c.getCaseParam(), ""); 
//	        System.out.println(response);       
	        String actvalue= Jsonfetch.json_string1(response, "code");
	        String expvalue = c.getCasePreset().get("code");
	        assertEquals(actvalue, expvalue);		
		}

}
