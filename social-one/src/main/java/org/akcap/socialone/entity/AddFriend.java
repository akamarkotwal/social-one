package org.akcap.socialone.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the add_friends database table.
 * 
 */
@Entity
@Table(name="add_friends")
@NamedQuery(name="AddFriend.findAll", query="SELECT a FROM AddFriend a")
public class AddFriend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAndTime;

	private byte isActive;

	private byte isDelete;

	private String message;

	private int status;

	private Integer updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	//bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name="FromID")
	private UserInfomation userInfomation1;

	//bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name="ToID")
	private UserInfomation userInfomation2;

	public AddFriend() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDateAndTime() {
		return this.dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
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

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
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