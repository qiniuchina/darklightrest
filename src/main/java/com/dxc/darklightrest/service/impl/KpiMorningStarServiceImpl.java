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
	public List<ArrayList<Map<String, Object>>> findAllKMSInfo() {
		List<ArrayList<Map<String, Object>>> resultList = new ArrayList<ArrayList<Map<String, Object>>>();
		
		List<String> kmsDataStrList = kpiMorningStarRepository.getAllDatestr();
		if(kmsDataStrList !=null && kmsDataStrList.size() >0) {
			for (String datastr : kmsDataStrList) {
				if(datastr !=null && !"".equals(datastr)) {
					List<Map<String, Object>> kmsList = kpiMorningStarRepository.getKMSByDatestr(datastr);
					ArrayList<Map<String, Object>> subResultList = new ArrayList<Map<String, Object>>();
					if(kmsList !=null && kmsList.size() >0) {
						
						for (Map<String, Object> kmsItem : kmsList) {
							if(kmsItem !=null) {
								Map<String, Object> temp = new HashMap<String, Object>();
								
								temp.put("stockId", kmsItem.get("stock_code"));   // 股票代码
								temp.put("StockName", kmsItem.get("stock_name")+"("+kmsItem.get("stock_code")+")");  // 股票名称
								temp.put("TotlePic", kmsItem.get("day_cut_off_yield"));   // 成为早晨之星后的总收益
								temp.put("MorningStarDt", kmsItem.get("stage_date_str"));   //出现早晨之星的日期
								
								StockCurrentPrice stockCurr=CommonUtil.getCurrentPriceByStockCode(CommonUtil.formatStockCode(String.valueOf(kmsItem.get("stock_code"))));
								if(stockCurr!=null){
									temp.put("TodayPic", Double.valueOf(stockCurr.getStockPrice()));    // 今日股票价格
									temp.put("TodayPerct", Double.valueOf(stockCurr.getStockUpdownPercent()));   //今日股票涨跌
								}
								subResultList.add(temp);
							}
						}
					}
					if(subResultList !=null && subResultList.size() >0) {
						resultList.add(subResultList);
					}
				}
				
			}
		}
		return resultList;
	}

}
