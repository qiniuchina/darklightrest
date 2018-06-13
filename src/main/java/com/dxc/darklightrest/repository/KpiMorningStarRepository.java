package com.dxc.darklightrest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dxc.darklightrest.entity.KpiMorningStar;

public interface KpiMorningStarRepository extends JpaRepository<KpiMorningStar, Integer> {
	
	@Query(value="select si.stock_code, si.stock_name, kms.stage_date_str, kms.day_cut_off_yield "
			+" from base_stocks si, kpi_morning_star kms "
			+" where si.stock_code =kms.stock_code and kms.stock_code = ?1",nativeQuery=true)
	Map<String, Object> getKMSByStockCode(String stockCode);

}
