package com.dxc.darklightrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.darklightrest.entity.KpiMorningStar;
import com.dxc.darklightrest.service.KpiMorningStarService;

import io.swagger.annotations.ApiOperation;

@RestController
public class KpiMoriningStarController {
	
	@Autowired
	private KpiMorningStarService kpiMorningStarService;
	
	@RequestMapping(value="/morning_star", method = {RequestMethod.GET})
	public Map<String, Object> getAllMorningStarInfo() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			List<Map<String, Object>> dataList = kpiMorningStarService.findAllKMSInfo();
			resultMap.put("code", 1);
			resultMap.put("msg", "请求成功");
			resultMap.put("data", dataList);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultMap;
		
	}

}
