package com.dxc.darklightrest.controller;

import java.util.List;

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
	
	@RequestMapping(value="/kpi_morning_star",method=RequestMethod.GET)  
	@ApiOperation(value="获取所有的列表",notes="不需要传递参数")
	public List<KpiMorningStar> FindAll() {
		return kpiMorningStarService.findAll();
		
	}

}
