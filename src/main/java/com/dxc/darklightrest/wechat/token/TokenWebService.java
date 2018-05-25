package com.dxc.darklightrest.wechat.token;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.dxc.darklightrest.wechat.App;
import com.dxc.darklightrest.wechat.WeChatUtil;


/**
 * 通过用户认证-----oauth2授权
 * https://api.weixin.qq.com/sns/oauth2/access_token
 * @author wenga
 *
 */
public class TokenWebService {
	
	private static final Logger log = LogManager.getLogger(TokenWebService.class);
	
	private static final String GETTOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
	
	private static final String VALIDATETOKEN = "https://api.weixin.qq.com/sns/auth";
	
	private static final String REFRESH_TOKEN = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
	
	
	private static final String TOKEN_STR_KEY = "access_token";
	
	private static final String TOKEN_STR_REFRESH = "refresh_token";
	
	private static final String OPEN_ID = "openid";
	
	private static final String LAST_DATE = "lastdate";
	
	private static final String USER_WXTOKEN = "user_wxtoken";
	
	
	/**
	 * 获取一个新的TokenWeb
	 * @param code
	 * @return
	 */
	public static TokenWeb getNewTokenWebObject(String code){
		TokenWeb tokenweb = null;
		
		String requestUrl = GETTOKEN + "?appid="+App.APP_ID+"&secret="+App.APP_SECRET+"&code="+code+"&grant_type=authorization_code";
		try {
			JSONObject jsonObject = WeChatUtil.httpsRequest(requestUrl, "GET", null);
			
			String tokenStr = jsonObject.getString(TOKEN_STR_KEY);
			String refreshToken = jsonObject.getString(TOKEN_STR_REFRESH);
			String openId = jsonObject.getString(OPEN_ID);
			
			tokenweb = new TokenWeb();
			tokenweb.setTokenStr(tokenStr);
			tokenweb.setRefreshToken(refreshToken);
			tokenweb.setDate(new Date());
			tokenweb.setOpenId(openId);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tokenweb;
		
	}
	
	/**
	 * tokenWeb对象转换成json
	 * @param tokenWeb 
	 * @return String
	 */
	public static String tokenWebToStr(TokenWeb tokenWeb){		
		String value =JSONObject.toJSONString(tokenWeb);
		return value;
	}
	
	
	/**
	 * 验证tokenweb是否有效
	 * @param tokenWeb
	 * @return true 有效, false 无效
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isValid(TokenWeb tokenWeb){
		//https://api.weixin.qq.com/sns/auth?access_token=ACCESS_TOKEN&openid=OPENID
		
		String requestUrl = VALIDATETOKEN + "?access_token="+tokenWeb.getTokenStr()+"&openid="+tokenWeb.getOpenId();
		
		try {
			JSONObject jsonObject = WeChatUtil.httpsRequest(requestUrl, "GET", null);
			int code = jsonObject.getInteger("errcode").intValue();
			
			if(code != 0){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	/**
	 * 用refresh_token刷新
	 * @param appid
	 * @param tokenWeb
	 * @return
	 */
	//https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN
	public static String getRefreshToken(String appid,TokenWeb tokenWeb){
		
		String requestUrl = REFRESH_TOKEN + "?appid="+appid+"&refresh_token="+tokenWeb.getRefreshToken()+"&grant_type=refresh_token";
		
		try {
			JSONObject jsonObject = WeChatUtil.httpsRequest(requestUrl, "GET", null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
