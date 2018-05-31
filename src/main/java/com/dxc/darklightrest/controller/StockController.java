package com.dxc.darklightrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.darklightrest.common.util.CommonUtil;
import com.dxc.darklightrest.entity.StockCurrentPrice;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/stock")
public class StockController 
{
	@RequestMapping(value="/stock_list",method=RequestMethod.GET)  
	@ApiOperation(value="",notes="")
	public Map<String, Object> getStockList(){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//获取大盘数据
			StockCurrentPrice shPrice = CommonUtil.getCurrentPriceByStockCode("sh000001");			
			StockCurrentPrice szPrice = CommonUtil.getCurrentPriceByStockCode("sz399001");
			StockCurrentPrice cyPrice = CommonUtil.getCurrentPriceByStockCode("sz399006");
			
			shPrice.setStockName(shPrice.getStockName().replace("quot;", ""));
			szPrice.setStockName(szPrice.getStockName().replace("quot;", ""));
			cyPrice.setStockName(cyPrice.getStockName().replace("quot;", ""));
			
			resultMap.put("shPrice", shPrice);
			resultMap.put("szPrice", szPrice);
			resultMap.put("cyPrice", cyPrice);
		 }
		catch (Exception e) {
			resultMap.put("code", -1);
			resultMap.put("msg", "请求失败");
		}
		return resultMap;
	}
	
}
