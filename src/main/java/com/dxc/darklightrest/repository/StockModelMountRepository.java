package com.dxc.darklightrest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.dxc.darklightrest.entity.StockModelMount;
import com.dxc.darklightrest.entity.StockModelMountId;

public interface StockModelMountRepository extends JpaRepository<StockModelMount, StockModelMountId>, JpaSpecificationExecutor<StockModelMount> {

	@Query(value="select * from(select tstock.*,sm.stock_code scode,sm.stock_date,sm.avg_mount,sm.avg_weight,sm.avg_price,"
			+ "ifnull(sm.flag_phase,-1) flag_phase from "
			+ "(select DISTINCT si.stock_code, si.stock_name,us.user_id from base_stocks si, user_stock us where user_id= ?1"
			+ " and si.stock_code =us.stock_code and us.is_deleted = 0 and us.stock_code!='1A0001' and "
			+ " us.stock_code!=399001 and us.stock_code!=399006)tstock "
			+ "left join stock_model_mount sm on tstock.stock_code=sm.stock_code where sm.end_date is null ORDER BY sm.stock_code, sm.stock_date desc) tbstock "
			+ "GROUP BY stock_code", nativeQuery = true)
	List<Map<String, Object>> getStockModelMountList(String userId);
	
	
}
