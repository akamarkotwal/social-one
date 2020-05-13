package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the personal_details database table.
 * 
 */
@Entity
@Table(name="personal_details")
@NamedQuery(name="PersonalDetail.findAll", query="SELECT p FROM PersonalDetail p")
public class PersonalDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String interested;

	private String language;

	private String mobileNo;

	private String movies;

	private String profilePic;

	private String religiousViews;

	private int updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	//bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name="UserID")
	private UserInfomation userInfomation;

	public PersonalDetail() {
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

	public String getInterested() {
		return this.interested;
	}

	public void setInterested(String interested) {
		this.interested = interested;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMovies() {
		return this.movies;
	}

	public void setMovies(String movies) {
		this.movies = movies;
	}

	public String getProfilePic() {
		return this.profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getReligiousViews() {
		return this.religiousViews;
	}

	public void setReligiousViews(String religiousViews) {
		this.religiousViews = religiousViews;
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