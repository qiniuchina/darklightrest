package com.dxc.darklightrest.wechat.token;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.dxc.darklightrest.wechat.WeChatUtil;

public class TokenService {
	
	private static final Logger log = LogManager.getLogger(TokenService.class);
	
	private static final String GETTOKEN = "https://api.weixin.qq.com/cgi-bin/token";
	
	private static final String ALI_GETTOKEN_URL = "http://www.76idea.com/darklight/weixin/token";
	
	private static final String TOKEN_DATE_KEY = "lastdate";
	
	private static final String TOKEN_STR_KEY = "access_token";
	
	private static final String TOKEN_KEY = "wxtoken";
	
	
	/**
	 * 获取一个新的Token
	 * @param appid
	 * @param appsecret
	 * @return
	 */
	public static Token getToken(String appid, String appsecret) {
        Token token = null;
        String requestUrl = GETTOKEN + "?grant_type=client_credential&appid=" + appid + "&secret=" + appsecret;
        // 发起GET请求获取凭证
        JSONObject jsonObject = WeChatUtil.httpsRequest(requestUrl, "GET", null);

        if (null != jsonObject) {
            try {
                token = new Token();
                token.setTokenStr(jsonObject.getString("access_token"));
                Date date = new Date();
                
                token.setDate(date);
            } catch (JSONException e) {
                token = null;
                // 获取token失败
                log.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInteger("errcode"), jsonObject.getString("errmsg"));
            }
        }
        return token;
    }

}
