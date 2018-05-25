package com.dxc.darklightrest.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.alibaba.fastjson.JSONObject;
import com.dxc.darklightrest.common.util.CommonUtil;
import com.dxc.darklightrest.entity.User;
import com.dxc.darklightrest.wechat.App;
import com.dxc.darklightrest.wechat.WeChatUserService;
import com.dxc.darklightrest.wechat.WeChatUtil;
import com.dxc.darklightrest.wechat.token.Token;
import com.dxc.darklightrest.wechat.token.TokenService;

@RestController
@RequestMapping(value="/weixin")
public class WeChatController {
	
	
	@RequestMapping(value = "/baseoauth", method = { RequestMethod.GET, RequestMethod.POST })
	public View getAuthBase(String action,String paramstr, HttpServletRequest request,HttpServletResponse response){
	//	String redirectUrl = "http://www.76idea.com/"+App.APP_NAME+"/"+action+"?scope=base";
		String redirectUrl = "http://www.76idea.com/"+App.APP_NAME+"/weixin/baseoauth?"+action+"?scope=base";
		if(!CommonUtil.isEmpty(paramstr))
		{
			redirectUrl += "&"+paramstr;
		}
		try {
			
			response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+App.APP_ID+"&redirect_uri="+
			URLEncoder.encode(redirectUrl, "utf-8")+"&response_type=code&scope=snsapi_base&state=123#wechat_redirect");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/oauth", method = { RequestMethod.GET, RequestMethod.POST })
	public View getAuthcode(String action,String paramstr, HttpServletRequest request,HttpServletResponse response){
		String redirectUrl = "http://www.76idea.com/"+App.APP_NAME+"/"+action+"?scope=userinfo";
		if(!CommonUtil.isEmpty(paramstr))
		{
			redirectUrl += "&"+paramstr;
		}
		
		try {
			response.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+App.APP_ID+"&redirect_uri="+
		URLEncoder.encode(redirectUrl, "utf-8")+"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect");
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/token", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView getToken(String passwd) {
		ModelAndView mv = null;
		Map<String, Object> data = new HashMap<String, Object>();
		String tokenStr = "";
		if("qiniuno1".equalsIgnoreCase(passwd))
		{
			try {
				Token gtoken = TokenService.getToken(App.APP_ID, App.APP_SECRET);
				tokenStr = gtoken.getTokenStr();
			} catch (Exception e) {
				tokenStr = "";
				e.printStackTrace();
			}
			data.put("token", tokenStr);
		}
		else
		{
			data.put("token", "");
		}
	    mv = new ModelAndView(new MappingJackson2JsonView(), data);
		return mv;
	}
	
	@RequestMapping(value="/userinfo",method=RequestMethod.GET)  
	public Map<String, Object> getUserInfo() {
		Map<String, Object> userMap = new HashMap<String, Object>();
		String accessToken = TokenService.getToken(App.APP_ID, App.APP_SECRET).getTokenStr();
		
		User weChatUser = WeChatUserService.getUserNew("oxw8iwedH7J7IFR4xV5qOpsxaHrc", accessToken);
		userMap.put("OpenID：", weChatUser.getUserId());
		userMap.put("关注状态：" , weChatUser.getSubscribe());
		userMap.put("昵称：" , weChatUser.getNickname());
		userMap.put("性别：", weChatUser.getSex());
		userMap.put("国家：", weChatUser.getCountry());
		userMap.put("省份：" , weChatUser.getProvince());
		userMap.put("城市：" , weChatUser.getCity());
		userMap.put("头像：" , weChatUser.getHeadimgurl());
		
		return userMap;
		
	}

}
