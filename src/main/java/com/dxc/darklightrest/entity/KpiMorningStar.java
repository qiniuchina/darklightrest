package com.dxc.darklightrest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kpi_morning_star", catalog = "darklight")
public class KpiMorningStar {
	
	@Id
	@Column(name="id",unique = true, nullable = false, length = 10)
    private Integer id;

	@Column(name="stock_code", length=6)
    private String stockCode;

	@Column(name="stage_date_str", length=10)
    private String stageDateStr;

	@Column(name="stage_comments", length=512)
    private String stageComments;

	@Column(name="day_cut_off_yield", length=10)
    private Float dayCutOffYield;

	@Column(name="stage_end_datestr", length=10)
    private String stageEndDatestr;

	@Column(name="weight", length=10)
    private Float weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStageDateStr() {
        return stageDateStr;
    }

    public void setStageDateStr(String stageDateStr) {
        this.stageDateStr = stageDateStr;
    }

    public String getStageComments() {
        return stageComments;
    }

    public void setStageComments(String stageComments) {
        this.stageComments = stageComments;
    }

    public Float getDayCutOffYield() {
        return dayCutOffYield;
    }

    public void setDayCutOffYield(Float dayCutOffYield) {
        this.dayCutOffYield = dayCutOffYield;
    }

    public String getStageEndDatestr() {
        return stageEndDatestr;
    }

    public void setStageEndDatestr(String stageEndDatestr) {
        this.stageEndDatestr = stageEndDatestr;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}