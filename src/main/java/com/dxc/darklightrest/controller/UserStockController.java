package com.dxc.darklightrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.darklightrest.common.util.CommonUtil;
import com.dxc.darklightrest.service.StockModelMountService;
import com.dxc.darklightrest.wechat.token.TokenWeb;
import com.dxc.darklightrest.wechat.token.TokenWebService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserStockController {
	@Autowired
	private StockModelMountService stockModelMountService;
	
	@RequestMapping(value="/user_stock_list",method=RequestMethod.POST)  
	@ApiOperation(value="",notes="")
	public Map<String, Object> getUserStockList(String userId){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			if(!CommonUtil.isEmpty(userId)) {
				List<Map<String, Object>> dataList = stockModelMountService.getStockModelMountList(userId);
				resultMap.put("code", 1);
				resultMap.put("msg", "请求成功");
				resultMap.put("data", dataList);
			}else {
				resultMap.put("code", 0);
				resultMap.put("msg", "");
			}
			
		}
		catch (Exception e) {
			resultMap.put("code", -1);
			resultMap.put("msg", "请求失败");
		}
		return resultMap;
	}
	
	@RequestMapping(value="/user_stock_listwx",method=RequestMethod.POST)  
	public Map<String, Object> getUserStockListWx(String code){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		TokenWeb tokenweb = TokenWebService.getNewTokenWebObject(code);
		String userId = tokenweb.getOpenId();
		resultMap = getUserStockList(userId);
		return resultMap;
		
	}
	

}
