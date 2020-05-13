package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the college_details database table.
 * 
 */
@Entity
@Table(name="college_details")
@NamedQuery(name="CollegeDetail.findAll", query="SELECT c FROM CollegeDetail c")
public class CollegeDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String achievement;

	private String collageName;

	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	private Integer updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	//bi-directional many-to-one association to MasterCourse
	@ManyToOne
	@JoinColumn(name="CourseID")
	private MasterCourse masterCourse;

	//bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name="UserID")
	private UserInfomation userInfomation;

	//bi-directional many-to-one association to MasterUniversity
	@ManyToOne
	@JoinColumn(name="UniversitiesID")
	private MasterUniversity masterUniversity;

	public CollegeDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAchievement() {
		return this.achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getCollageName() {
		return this.collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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

	public MasterCourse getMasterCourse() {
		return this.masterCourse;
	}

	public void setMasterCourse(MasterCourse masterCourse) {
		this.masterCourse = masterCourse;
	}

	public UserInfomation getUserInfomation() {
		return this.userInfomation;
	}

	public void setUserInfomation(UserInfomation userInfomation) {
		this.userInfomation = userInfomation;
	}

	public MasterUniversity getMasterUniversity() {
		return this.masterUniversity;
	}

	public void setMasterUniversity(MasterUniversity masterUniversity) {
		this.masterUniversity = masterUniversity;
	}

}