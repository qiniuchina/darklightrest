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

/**
 * UserComments generated by hbm2java
 */
@Entity
@Table(name = "user_comments", catalog = "darklight")
public class UserComments implements java.io.Serializable {

	private Integer id;
	private String userId;
	private String commentsId;
	private int reviewResult;
	private Date createDtm;
	private String createBy;
	private String exOne;
	private Integer exTwo;

	public UserComments() {
	}

	public UserComments(String userId, String commentsId, int reviewResult, Date createDtm, String createBy) {
		this.userId = userId;
		this.commentsId = commentsId;
		this.reviewResult = reviewResult;
		this.createDtm = createDtm;
		this.createBy = createBy;
	}

	public UserComments(String userId, String commentsId, int reviewResult, Date createDtm, String createBy,
			String exOne, Integer exTwo) {
		this.userId = userId;
		this.commentsId = commentsId;
		this.reviewResult = reviewResult;
		this.createDtm = createDtm;
		this.createBy = createBy;
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

	@Column(name = "user_id", nullable = false, length = 32)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "comments_id", nullable = false, length = 32)
	public String getCommentsId() {
		return this.commentsId;
	}

	public void setCommentsId(String commentsId) {
		this.commentsId = commentsId;
	}

	@Column(name = "review_result", nullable = false)
	public int getReviewResult() {
		return this.reviewResult;
	}

	public void setReviewResult(int reviewResult) {
		this.reviewResult = reviewResult;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_dtm", nullable = false, length = 19)
	public Date getCreateDtm() {
		return this.createDtm;
	}

	public void setCreateDtm(Date createDtm) {
		this.createDtm = createDtm;
	}

	@Column(name = "create_by", nullable = false, length = 32)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
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