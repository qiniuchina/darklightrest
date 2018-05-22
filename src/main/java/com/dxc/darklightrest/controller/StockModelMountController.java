package com.dxc.darklightrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.darklightrest.service.StockModelMountService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/user")
public class StockModelMountController {
	
	@Autowired
	private StockModelMountService stockModelMountService;
	
	@RequestMapping(value="/user_stock_list",method=RequestMethod.POST)  
	@ApiOperation(value="",notes="")
	public Map<String, Object> getStockModelMountList(String userId){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> dataList = stockModelMountService.getStockModelMountList(userId);
			resultMap.put("code", 1);
			resultMap.put("msg", "请求成功");
			resultMap.put("data", dataList);
		}
		catch (Exception e) {
			resultMap.put("code", -1);
			resultMap.put("msg", "请求失败");
		}
		return resultMap;
	}
	
}
