package com.dxc.darklightrest.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.darklightrest.common.util.CommonUtil;
import com.dxc.darklightrest.entity.KpiMorningStar;
import com.dxc.darklightrest.entity.StockCurrentPrice;
import com.dxc.darklightrest.repository.KpiMorningStarRepository;
import com.dxc.darklightrest.service.KpiMorningStarService;

@Service
public class KpiMorningStarServiceImpl implements KpiMorningStarService {

	@Autowired
	private KpiMorningStarRepository kpiMorningStarRepository;
	
	@Override
	public List<KpiMorningStar> findAll() {	
		return kpiMorningStarRepository.findAll();
	}

	@Override
	public List<Map<String, Object>> findAllKMSInfo() {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
		List<KpiMorningStar> kmsList = kpiMorningStarRepository.findAll();
		if(kmsList !=null && kmsList.size() >0) {
			for (KpiMorningStar kmsItem : kmsList) {
				if(kmsItem !=null) {
					Map<String, Object> temp = new HashMap<String, Object>();
					
					Map<String, Object> kmsItemBySC = kpiMorningStarRepository.getKMSByStockCode(kmsItem.getStockCode());
					
					temp.put("stockId", kmsItemBySC.get("stock_code"));   // 股票代码
					temp.put("StockName", kmsItemBySC.get("stock_name")+"("+kmsItemBySC.get("stock_code")+")");  // 股票名称
					temp.put("TotlePic", kmsItemBySC.get("day_cut_off_yield"));   // 成为早晨之星后的总收益
					temp.put("MorningStarDt", kmsItemBySC.get("stage_date_str"));   //出现早晨之星的日期
					
					StockCurrentPrice stockCurr=CommonUtil.getCurrentPriceByStockCode(CommonUtil.formatStockCode(String.valueOf(kmsItem.getStockCode())));
					if(stockCurr!=null){
						temp.put("TodayPic", Double.valueOf(stockCurr.getStockPrice()));    // 今日股票价格
						temp.put("TodayPerct", Double.valueOf(stockCurr.getStockUpdownPercent()));   //今日股票涨跌
					}
					
					resultList.add(temp);
				}
			}
		}
		
		return resultList;
	}

}
