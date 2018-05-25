package com.dxc.darklightrest.wechat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class App {
	/** 基础权限，只获得 openId-直接302*/
	public static final String SCOPE_BASE = "snsapi_base";
	/** 高级权限，获得用户详细信息-有弹出确认*/
	public static final String SCOPE_USERINFO = "snsapi_userinfo";
	private static Log log = LogFactory.getLog(App.class);
	/** 所有涉及到appId的都从 TokenService.appId 获取 -->注意 appId  appsecrect 不允许修改*/
    /** 默认是正式环境appId*/
    public static String APP_ID = "wx4315ad5a9a5f1bfb";
    /** 默认是正式环境appsecrect*/
    public static String APP_SECRET = "e207cd45f96978428d4888319e114ee1";
    /** 微信公众平台支付功能-商户号ID*/
//    public static String MCH_ID = "1248851801";
    /** 微信公众平台支付功能-支付密码*/
    public static String PAY_SECRET = "A4ObsmD6dzxAAvtGz2zW2CkHZUaQYsFb";
    /** 默认是正式环镜服务器域名*/
 //   public static String APP_SERVER = ConfFactory.getConf().get("server.host", "www.76idea.com");
 //  	public static boolean serverDebug =  ConfFactory.getConf().getBoolean("server.debug",false);

    /** 默认是正式环镜服务器域名*/
    public static String APP_NAME = "darklight";  
    
    /** 默认是正式环镜服务器域名*/
    public static String ALI_GETTOKEN = "qiniuno1";
    
   
  /* 
    static {
        //如果是测试环境
        if (HostConfig.weixinDebug) {
            APP_ID = "wx4315ad5a9a5f1bfb";
            APP_SECRET = "e207cd45f96978428d4888319e114ee1";
            APP_NAME = "darklight";    
            PAY_SECRET = "A4ObsmD6dzxAAvtGz2zW2CkHZUaQYsFb";
        }
        log.debug(HostConfig.weixinDebug ? "测试环境" : "生产环境");
        log.debug("APP_ID : " + APP_ID);
        log.debug("APP_SECRET : " + APP_SECRET);
        log.debug("APP_SERVER : " + APP_SERVER);
        log.debug("APP_NAME : " + APP_NAME);
        log.debug("PAY_SECRET : " + PAY_SECRET);        
    }
  */
    public static String STOCK_NEWS_URL_PRE="http://www.76idea.com/darklight/stock/detail?stockCode=";
    public static String STOCK_LIST_URL_PRE="http://www.76idea.com/darklight/stock/list?";

}
