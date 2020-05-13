package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_sociallinks database table.
 * 
 */
@Entity
@Table(name="user_sociallinks")
@NamedQuery(name="UserSociallink.findAll", query="SELECT u FROM UserSociallink u")
public class UserSociallink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String facebook;

	private String google;

	private String instagram;

	private String twitter;

	private int updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	//bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name="UserId")
	private UserInfomation userInfomation;

	public UserSociallink() {
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

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getGoogle() {
		return this.google;
	}

	public void setGoogle(String google) {
		this.google = google;
	}

	public String getInstagram() {
		return this.instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
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

	public UserInfomation getUserInfomation() {
		return this.userInfomation;
	}

	public void setUserInfomation(UserInfomation userInfomation) {
		this.userInfomation = userInfomation;
	}

}