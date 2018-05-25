package com.dxc.darklightrest.wechat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.dxc.darklightrest.common.util.CommonUtil;


public class WeChatUtil {
	private static final Logger log = LogManager.getLogger(WeChatUtil.class);
	private static String TEMPLATE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";

	/**
	 * 发起Https请求并获取结果
	 * @param requestUrl 请求URL
	 * @param requestMethod 请求方式(GET/POST)
	 * @param outputStr 提交数据
	 * @return JSONObject
	 */
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr){
		JSONObject json = null;
		StringBuffer sb = new StringBuffer();
		try{
			//创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = {new MyX509TrustManager()};
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			//从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			/*
			 * 
			HttpsURLConnection conn =null;
			Proxy proxy = null;
			String proxyHost = ConfFactory.getConf().get("http.proxy.host");
			if (CommonUtil.notEmpty(proxyHost))
			{
				InetSocketAddress addr = new InetSocketAddress(proxyHost,8080);  
	            proxy = new Proxy(Proxy.Type.HTTP, addr);
	            conn=(HttpsURLConnection)url.openConnection(proxy);
			}else{
				conn=(HttpsURLConnection)url.openConnection();
			}
			
			*/
			conn.setSSLSocketFactory(ssf);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			//设置请求方式
			conn.setRequestMethod(requestMethod);
			if("GET".equalsIgnoreCase(requestMethod)){
				conn.connect();
			}
			//当有数据提交时
			if(CommonUtil.notEmpty(outputStr)){
				OutputStream os = conn.getOutputStream();
				//注意编码格式，防止中文乱码
				os.write(outputStr.getBytes("UTF-8"));
				os.close();
			}
			
			//将返回的输入流转换为字符串
			InputStream is = conn.getInputStream();
			InputStreamReader read = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(read);
			String str = null;
			while((str = br.readLine()) != null){
				sb.append(str);
			}
			br.close();
			read.close();
			is.close();
			is = null;
			conn.disconnect();
			json = JSONObject.parseObject(sb.toString());
		}catch (ConnectException  ce) {
			log.error("连接超时：{}", ce);
			ce.printStackTrace();
		}
		catch(Exception e){
			log.debug("https request error !!!"+e.getMessage());
			e.printStackTrace();
		}
		return json;
	}
	
	
	
}
