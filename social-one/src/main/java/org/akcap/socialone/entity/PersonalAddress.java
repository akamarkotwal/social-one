package org.akcap.socialone.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the personal_address database table.
 * 
 */
@Entity
@Table(name="personal_address")
@NamedQuery(name="PersonalAddress.findAll", query="SELECT p FROM PersonalAddress p")
public class PersonalAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String addressLine1;

	private String addressLine2;

	private int createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String landMark;

	private String pinCode;

	private int updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	//bi-directional many-to-one association to MasterCity
	@ManyToOne
	@JoinColumn(name="CityID")
	private MasterCity masterCity;

	//bi-directional many-to-one association to MasterCountry
	@ManyToOne
	@JoinColumn(name="CountryID")
	private MasterCountry masterCountry;

	//bi-directional many-to-one association to MasterState
	@ManyToOne
	@JoinColumn(name="StateID")
	private MasterState masterState;

	//bi-directional many-to-one association to UserInfomation
	@ManyToOne
	@JoinColumn(name="UserID")
	private UserInfomation userInfomation;

	public PersonalAddress() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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

	public String getLandMark() {
		return this.landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
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

	public MasterCity getMasterCity() {
		return this.masterCity;
	}

	public void setMasterCity(MasterCity masterCity) {
		this.masterCity = masterCity;
	}

	public MasterCountry getMasterCountry() {
		return this.masterCountry;
	}

	public void setMasterCountry(MasterCountry masterCountry) {
		this.masterCountry = masterCountry;
	}

	public MasterState getMasterState() {
		return this.masterState;
	}

	public void setMasterState(MasterState masterState) {
		this.masterState = masterState;
	}

	public UserInfomation getUserInfomation() {
		return this.userInfomation;
	}

	public void setUserInfomation(UserInfomation userInfomation) {
		this.userInfomation = userInfomation;
	}

}