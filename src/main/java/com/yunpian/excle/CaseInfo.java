package com.yunpian.excle;

import java.util.Map;


//接口参数存储中间类
public class CaseInfo {
	//用例参数 在excel中直接以字段名开头
    private Map<String,String> caseParam;
    //用例说明 在excel中以{$d}开头
    private Map<String,String> caseDesc;
    //用例期望结果 在excel中以{$p}开头
    private Map<String,String> casePreset;
    
    public Map<String, String> getCaseParam() {
        return caseParam;
    }
    public void setCaseParam(Map<String, String> caseParam) {
        this.caseParam = caseParam;
    }
    public Map<String, String> getCaseDesc() {
        return caseDesc;
    }
    public void setCaseDesc(Map<String, String> caseDesc) {
        this.caseDesc = caseDesc;
    }
    public Map<String, String> getCasePreset() {
        return casePreset;
    }
    public void setCasePreset(Map<String, String> casePreset) {
        this.casePreset = casePreset;
    }
   
}
