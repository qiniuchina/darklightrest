package com.dxc.darklightrest.entity;
// Generated 2018-5-21 13:58:10 by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * StockNews generated by hbm2java
 */
@Entity
@Table(name = "stock_news", catalog = "darklight")
public class StockNews implements java.io.Serializable {

	private String id;
	private String title;
	private String newsLink;
	private Date pubDate;
	private String stockCode;
	private String media;
	private Date createDt;
	private int statusFlag;
	private Date updateDt;
	private int bearFlag;
	private double changeRate;
	private int newsSource;
	private Integer topNum;

	public StockNews() {
	}

	public StockNews(String id, String title, String newsLink, String stockCode, Date createDt, int statusFlag,
			Date updateDt, int bearFlag, double changeRate, int newsSource) {
		this.id = id;
		this.title = title;
		this.newsLink = newsLink;
		this.stockCode = stockCode;
		this.createDt = createDt;
		this.statusFlag = statusFlag;
		this.updateDt = updateDt;
		this.bearFlag = bearFlag;
		this.changeRate = changeRate;
		this.newsSource = newsSource;
	}

	public StockNews(String id, String title, String newsLink, Date pubDate, String stockCode, String media,
			Date createDt, int statusFlag, Date updateDt, int bearFlag, double changeRate, int newsSource,
			Integer topNum) {
		this.id = id;
		this.title = title;
		this.newsLink = newsLink;
		this.pubDate = pubDate;
		this.stockCode = stockCode;
		this.media = media;
		this.createDt = createDt;
		this.statusFlag = statusFlag;
		this.updateDt = updateDt;
		this.bearFlag = bearFlag;
		this.changeRate = changeRate;
		this.newsSource = newsSource;
		this.topNum = topNum;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false, length = 20)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "title", nullable = false, length = 256)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "news_link", nullable = false, length = 128)
	public String getNewsLink() {
		return this.newsLink;
	}

	public void setNewsLink(String newsLink) {
		this.newsLink = newsLink;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pub_date", length = 19)
	public Date getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	@Column(name = "stock_code", nullable = false, length = 20)
	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "media", length = 20)
	public String getMedia() {
		return this.media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_dt", nullable = false, length = 19)
	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Column(name = "status_flag", nullable = false)
	public int getStatusFlag() {
		return this.statusFlag;
	}

	public void setStatusFlag(int statusFlag) {
		this.statusFlag = statusFlag;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_dt", nullable = false, length = 19)
	public Date getUpdateDt() {
		return this.updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Column(name = "bear_flag", nullable = false)
	public int getBearFlag() {
		return this.bearFlag;
	}

	public void setBearFlag(int bearFlag) {
		this.bearFlag = bearFlag;
	}

	@Column(name = "change_rate", nullable = false, precision = 10, scale = 4)
	public double getChangeRate() {
		return this.changeRate;
	}

	public void setChangeRate(double changeRate) {
		this.changeRate = changeRate;
	}

	@Column(name = "news_source", nullable = false)
	public int getNewsSource() {
		return this.newsSource;
	}

	public void setNewsSource(int newsSource) {
		this.newsSource = newsSource;
	}

	@Column(name = "top_num")
	public Integer getTopNum() {
		return this.topNum;
	}

	public void setTopNum(Integer topNum) {
		this.topNum = topNum;
	}

}
