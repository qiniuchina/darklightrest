package com.dxc.darklightrest.service;

import java.util.List;
import java.util.Map;

import com.dxc.darklightrest.entity.KpiMorningStar;


public interface KpiMorningStarService {
	
	List<KpiMorningStar> findAll();
	
	/**
	 * 查询所有的早晨之星信息
	 * Map中包含:
	 * stockId:     // 股票代码
	 * StockName:   // 股票名称
	 * TodayPic:    //今日股价
	 * TodayPerct:  //今日涨跌幅
	 * TotlePic:    //成为早晨之星后的总收益
	 * TotlePerct:  //成为早晨之星后的总涨跌幅
	 * MorningStarDt: //出现早晨之星的日期
	 * MorningStarDays:  //持续早晨之星阶段的天数
	 * @return
	 */
	List<Map<String, Object>> findAllKMSInfo();
}
