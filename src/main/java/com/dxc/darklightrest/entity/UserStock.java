package com.dxc.darklightrest.entity;
// Generated 2018-5-21 13:58:10 by Hibernate Tools 5.2.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * UserStock generated by hbm2java
 */
@Entity
@Table(name = "user_stock", catalog = "darklight")
public class UserStock implements java.io.Serializable {

	private Integer id;
	private String version;
	private String userId;
	private String stockCode;
	private Date createDtm;
	private Date updateDtm;
	private String updateBy;
	private String createBy;
	private Byte isDeleted;
	private String exOne;
	private Integer exTwo;

	public UserStock() {
	}

	public UserStock(String userId, String stockCode, Date createDtm, Date updateDtm, String updateBy, String createBy,
			Byte isDeleted, String exOne, Integer exTwo) {
		this.userId = userId;
		this.stockCode = stockCode;
		this.createDtm = createDtm;
		this.updateDtm = updateDtm;
		this.updateBy = updateBy;
		this.createBy = createBy;
		this.isDeleted = isDeleted;
		this.exOne = exOne;
		this.exTwo = exTwo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "version", length = 8)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "user_id", length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "stock_code", length = 256)
	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_dtm", length = 19)
	public Date getCreateDtm() {
		return this.createDtm;
	}

	public void setCreateDtm(Date createDtm) {
		this.createDtm = createDtm;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_dtm", length = 19)
	public Date getUpdateDtm() {
		return this.updateDtm;
	}

	public void setUpdateDtm(Date updateDtm) {
		this.updateDtm = updateDtm;
	}

	@Column(name = "update_by", length = 32)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name = "create_by", length = 32)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name = "is_deleted")
	public Byte getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Byte isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "ex_one", length = 32)
	public String getExOne() {
		return this.exOne;
	}

	public void setExOne(String exOne) {
		this.exOne = exOne;
	}

	@Column(name = "ex_two")
	public Integer getExTwo() {
		return this.exTwo;
	}

	public void setExTwo(Integer exTwo) {
		this.exTwo = exTwo;
	}

}
