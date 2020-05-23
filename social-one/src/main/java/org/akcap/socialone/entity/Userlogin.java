package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;



import java.util.Date;
import java.util.List;


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

	@Column(name="LoginUserName")
	private String userName;

	
	private Date modifiedAt;

	private String password;
	
	@OneToOne
	@JoinColumn(name="userID")
	private UserInfomation userInfomation;

	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;
	
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

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public UserInfomation getUserInfomation() {
		return userInfomation;
	}

	public void setUserInfomation(UserInfomation userInfomation) {
		this.userInfomation = userInfomation;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
}