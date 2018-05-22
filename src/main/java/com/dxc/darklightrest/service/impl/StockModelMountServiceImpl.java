package com.dxc.darklightrest.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.darklightrest.common.util.CommonUtil;
import com.dxc.darklightrest.entity.StockCurrentPrice;
import com.dxc.darklightrest.repository.BlackStocksRepository;
import com.dxc.darklightrest.repository.StockModelMountRepository;
import com.dxc.darklightrest.service.StockModelMountService;

@Service("stockModelMountService")
public class StockModelMountServiceImpl implements StockModelMountService {

	@Autowired
	private BlackStocksRepository blackStocksRepository;
	
	@Autowired
	private StockModelMountRepository stockModelMountRepository;

	@Override
	public List<Map<String, Object>> getStockModelMountList(String userId) {
		List<Map<String, Object>> resultMap = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> stockModelMountList = stockModelMountRepository.getStockModelMountList(userId);
		if(stockModelMountList!=null && stockModelMountList.size() >0) {
			for (Map<String, Object> map : stockModelMountList) {
				Map<String, Object> temp = new HashMap<String, Object>();
				temp.put("stockId", map.get("stock_code"));   // 股票id
				temp.put("StockName", map.get("stock_name"));  // 股票名称
				
				int phase = ((BigInteger) map.get("flag_phase")).intValue();    // 股票状态
				if(STOCK_DROP_PHASE==phase){
					temp.put("CurrentInfo", STOCK_DROP_PHASE_STR);
				}else if(STOCK_SHOCK_PHASE==phase){
					temp.put("CurrentInfo", STOCK_SHOCK_PHASE_STR);
				}else if(STOCK_STABLE_PHASE==phase){
					temp.put("CurrentInfo", STOCK_STABLE_PHASE_STR);
				}else if(STOCK_RISE_PHASE==phase){
					temp.put("CurrentInfo", STOCK_RISE_PHASE_STR);
				}else if(STOCK_END_PHASE==phase){
					temp.put("CurrentInfo", STOCK_END_PHASE_STR);
				}
				else{
					temp.put("CurrentInfo", STOCK_ERROR_PHASE_STR);
				}
				StockCurrentPrice stockCurr=CommonUtil.getCurrentPriceByStockCode(CommonUtil.formatStockCode(String.valueOf(map.get("stock_code"))));
				if(stockCurr!=null){
					temp.put("TodayPic", String.valueOf(stockCurr.getStockPrice()));
					temp.put("TodayPerct", String.valueOf(stockCurr.getStockUpdownPercent())+"%");
				}
				
				resultMap.add(temp);
			}
			
		}
		return resultMap;
	}
}
