package com.yunpian.http;


//url的一些参数定义
public class Urlparams {
	public static String host = "https://www.yunpian.com";
	
	public static String charset = "utf-8";
	
	public static String loginTest = "https://test-web.yunpian.com/component/login"; //登陆接口地址
	
	public static String sendNsms = "https://test-web.yunpian.com/api/domestic/test/send"; //国内短信发送测试接口
	
	public static String inspectNTest = "https://test-web.yunpian.com/api/domestic/test/blackWord/inspect"; //国内敏感词接口

	public static String whiteNTest = "https://test-web.yunpian.com/api/domestic/test/whitelist/save"; //国内白名单保存

	public static String whiteGNTest = "https://test-web.yunpian.com/api/domestic/test/whitelist/get"; //国内白名单获取

	public static String signGsearch = "https://test-web.yunpian.com/admin/applysign/sign_setting_ajax"; //国内签名获取

	public static String signGpost = "https://test-web.yunpian.com/admin/applysign/add_sign"; //国内新增签名

	public static String signNdelete = "https://test-web.yunpian.com/admin/applysign/del_sign"; //国内删除签名

	public static String tplNadd = "https://test-web.yunpian.com/admin/template/tpl_add"; //国内添加模版

	public static String tplNlist = "https://test-web.yunpian.com/admin/template/tpl_list"; //国内搜索模版
		
	public static String tplNdel = "https://test-web.yunpian.com/admin/module/tpl_del"; //国内删除模版
	
	public static String recordNlist = "https://test-web.yunpian.com/admin/module/batch/getHistoryRecordList"; //国内群发列表

	public static String getIngAndSuccessSigns = "https://test-web.yunpian.com/admin/applysign/getIngAndSuccessSigns"; //国内获取模版添加内容输入框

	public static String getHistoryContentList = "https://test-web.yunpian.com/admin/module/batch/getHistoryContentList"; //国内获取群发计划发送纪录

	public static String sendNApply = "https://test-web.yunpian.com/admin/module/batch/createSendApply"; //国内新建群发计划

	public static String Nrealtime = "https://test-web.yunpian.com/admin/stat/receive/realtime"; //短信发送量／短信到达率实时统计

	public static String Nhistory = "https://test-web.yunpian.com/admin/stat/receive/history"; //短信发送量／短信到达率历史统计

	public static String failedNDist = "https://test-web.yunpian.com/admin/stat/all/failedDist"; //短信失败原因统计

	public static String Ndelay = "https://test-web.yunpian.com/admin/stat/all/delay"; //短信耗时统计

	public static String regNSmsStat = "https://test-web.yunpian.com/admin/stat/regSmsStat"; //注册成功率统计

	public static String add_blacklist = "https://test-web.yunpian.com/admin/sms/ajax/add_blacklist"; //添加黑名单

	public static String remove_blacklist = "https://test-web.yunpian.com/admin/sms/ajax/remove_blacklist_numbers"; //删除黑名单
	
	public static String blacklist = "https://test-web.yunpian.com/admin/sms/ajax/blacklist_records"; //查询黑名单
	
	public static String smsN_record = "https://test-web.yunpian.com/admin/module/ajax/sms_record"; //查询黑名单

	public static String createShortUrl = "https://test-web.yunpian.com/admin/module/batch/createShortUrl";
	
	public static String getShortUrl = "https://test-web.yunpian.com/admin/module/batch/getShortUrl"; //点击统计
	
	public static String getUrlStat = "https://test-web.yunpian.com/admin/module/batch/getUrlStat";
	
	
	
	

}
