package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the userlogin database table.
 * 
 */
@Entity
@NamedQuery(name="Userlogin.findAll", query="SELECT u FROM Userlogin u")
public class Userlogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int userID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	private byte isActive;

	private byte isDelete;

	private String loginUserName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedAt;

	private String password;

	public Userlogin() {
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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

	public String getLoginUserName() {
		return this.loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public Date getModifiedAt() {
		return this.modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}