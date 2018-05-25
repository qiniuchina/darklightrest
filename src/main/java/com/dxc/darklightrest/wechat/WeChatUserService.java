package com.dxc.darklightrest.wechat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;
import com.dxc.darklightrest.entity.User;

public class WeChatUserService {
	
	private static final Log log = LogFactory.getLog(WeChatUserService.class);
	
	/**新接口获取用户信息*/
	private static final String GET_USER1 = "https://api.weixin.qq.com/cgi-bin/user/info";
	
	public static User getUserNew(String openId, String accessToken) {
		User weChatUser = null;
		String requestUrl = GET_USER1 + "?access_token="+accessToken+"&openid="+openId;
		JSONObject jsonObject = WeChatUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
            try {
            	weChatUser = new User();
                // 用户的标识
            	weChatUser.setUserId(jsonObject.getString("openid"));
                // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
            	int subscribe = jsonObject.getInteger("subscribe") ==null ? 0 : jsonObject.getInteger("subscribe").intValue();
            	if(subscribe !=0 ) {
            		weChatUser.setSubscribe(subscribe);
            		weChatUser.setNickname(jsonObject.getString("nickname"));
            		
            		int sex = jsonObject.getInteger("sex") ==null ? 0 : jsonObject.getInteger("sex").intValue();
        			weChatUser.setSex(sex);
        			
        			weChatUser.setCity(jsonObject.getString("city"));
        			weChatUser.setProvince(jsonObject.getString("province"));
        			weChatUser.setCountry(jsonObject.getString("country"));
        			weChatUser.setHeadimgurl(jsonObject.getString("headimgurl"));
        			weChatUser.setUnionId(jsonObject.getString("unionid"));
        		}else
        			log.error("用户 " + weChatUser.getUserId() + "已取消关注");
                
            } catch (Exception e) {
                    int errorCode = jsonObject.getInteger("errcode").intValue();
                    String errorMsg = jsonObject.getString("errmsg");
                    log.error("获取用户信息失败 errcode:{"+errorCode+"} errmsg:{"+errorMsg+"}");
                
            }
        }
		return weChatUser;
		
		
	}

}
