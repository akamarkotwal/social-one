package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the master_course database table.
 * 
 */
@Entity
@Table(name="master_course")
@NamedQuery(name="MasterCourse.findAll", query="SELECT m FROM MasterCourse m")
public class MasterCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String courseID;

	private String courseName;

	//bi-directional many-to-one association to CollegeDetail
	@OneToMany(mappedBy="masterCourse")
	private List<CollegeDetail> collegeDetails;

	public MasterCourse() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseID() {
		return this.courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@JsonIgnore
	public List<CollegeDetail> getCollegeDetails() {
		return this.collegeDetails;
	}

	public void setCollegeDetails(List<CollegeDetail> collegeDetails) {
		this.collegeDetails = collegeDetails;
	}

	public CollegeDetail addCollegeDetail(CollegeDetail collegeDetail) {
		getCollegeDetails().add(collegeDetail);
		collegeDetail.setMasterCourse(this);

		return collegeDetail;
	}

	public CollegeDetail removeCollegeDetail(CollegeDetail collegeDetail) {
		getCollegeDetails().remove(collegeDetail);
		collegeDetail.setMasterCourse(null);

		return collegeDetail;
	}

}