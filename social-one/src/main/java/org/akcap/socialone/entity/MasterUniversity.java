package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the master_universities database table.
 * 
 */
@Entity
@Table(name="master_universities")
@NamedQuery(name="MasterUniversity.findAll", query="SELECT m FROM MasterUniversity m")
public class MasterUniversity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	//bi-directional many-to-one association to CollegeDetail
	@OneToMany(mappedBy="masterUniversity")
	private List<CollegeDetail> collegeDetails;

	public MasterUniversity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
		collegeDetail.setMasterUniversity(this);

		return collegeDetail;
	}

	public CollegeDetail removeCollegeDetail(CollegeDetail collegeDetail) {
		getCollegeDetails().remove(collegeDetail);
		collegeDetail.setMasterUniversity(null);

		return collegeDetail;
	}

}