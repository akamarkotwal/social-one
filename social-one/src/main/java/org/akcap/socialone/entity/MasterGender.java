package org.akcap.socialone.entity;


import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the master_gender database table.
 * 
 */
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="master_gender")
@NamedQuery(name="MasterGender.findAll", query="SELECT m FROM MasterGender m")
public class MasterGender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String gender;

	//bi-directional many-to-one association to UserInfomation
	
	@OneToMany(mappedBy="masterGender")
	private List<UserInfomation> userInfomations;

	public MasterGender() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonIgnore
	public List<UserInfomation> getUserInfomations() {
		return this.userInfomations;
	}

	public void setUserInfomations(List<UserInfomation> userInfomations) {
		this.userInfomations = userInfomations;
	}

	public UserInfomation addUserInfomation(UserInfomation userInfomation) {
		getUserInfomations().add(userInfomation);
		userInfomation.setMasterGender(this);

		return userInfomation;
	}

	public UserInfomation removeUserInfomation(UserInfomation userInfomation) {
		getUserInfomations().remove(userInfomation);
		userInfomation.setMasterGender(null);

		return userInfomation;
	}

}