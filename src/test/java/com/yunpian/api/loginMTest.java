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

public class loginMTest {
	 protected String caseExcelPath ="src/test/resource/loginTest.xlsx";
		
		@DataProvider(name = "dataInfo")
	    protected Object[][] dataInfo() throws IOException {
	        Object[][] myObj = null;
	        System.out.println(caseExcelPath);
	        List<Map<String, String>> list = ReadExcel.readXlxs(caseExcelPath);
	        myObj = CaseHelper.getObjArrByList(list);
	        return myObj;
		}
		
		@Test(dataProvider = "dataInfo")
			public void test_loginTest(CaseInfo c) throws IOException{
	        String url = Urlparams.loginTest; 
	        String actvalue = null;
	        String response = HttpClientUtil.dopost(url, c.getCaseParam(),"","1"); 
//	        System.out.println(response); 
	        if ( Jsonfetch.json_string1(response, "success") !=null) {
	          	 actvalue= Jsonfetch.json_string1(response, "success");
	        }
	        else
	        	{
	        	     actvalue= Jsonfetch.json_string1(response, "message");
	        	}
	        String expvalue = c.getCasePreset().get("success");
	        assertEquals(actvalue, expvalue);		
		}	

}
