package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Date;


/**
 * The persistent class for the friendship database table.
 * 
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name="Friendship.findAll", query="SELECT f FROM Friendship f")
public class Friendship implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEstablished;

	private byte isActive;

	private byte isDelete;

	private int updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	//bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name="PersonId1")
	private UserInfomation userInfomation1;

	//bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name="PersonId2")
	private UserInfomation userInfomation2;

	public Friendship() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDateEstablished() {
		return this.dateEstablished;
	}

	public void setDateEstablished(Date dateEstablished) {
		this.dateEstablished = dateEstablished;
	}

	public byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(byte isActive) {
		this.isActive = isActive;
	}

	public byte getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}

	public int getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UserInfomation getUserInfomation1() {
		return this.userInfomation1;
	}

	public void setUserInfomation1(UserInfomation userInfomation1) {
		this.userInfomation1 = userInfomation1;
	}

	public UserInfomation getUserInfomation2() {
		return this.userInfomation2;
	}

	public void setUserInfomation2(UserInfomation userInfomation2) {
		this.userInfomation2 = userInfomation2;
	}

}