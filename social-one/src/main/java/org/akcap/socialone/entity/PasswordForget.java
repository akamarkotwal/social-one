package org.akcap.socialone.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;



/**
 * The persistent class for the password_forget database table.
 * 
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="password_forget")
@NamedQuery(name="PasswordForget.findAll", query="SELECT p FROM PasswordForget p")
public class PasswordForget implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int createBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDateTime;

	private String token;

	private int updateBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	//bi-directional many-to-one association to Userlogin
	@ManyToOne
	@JoinColumn(name="UserID")
	private Userlogin userlogin;

	public PasswordForget() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(int updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Userlogin getUserlogin() {
		return this.userlogin;
	}

	public void setUserlogin(Userlogin userlogin) {
		this.userlogin = userlogin;
	}

}