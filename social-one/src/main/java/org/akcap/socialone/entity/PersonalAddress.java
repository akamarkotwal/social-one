package org.akcap.socialone.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Date;

/**
 * The persistent class for the personal_address database table.
 * 
 */
@Entity
@Table(name = "personal_address")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NamedQuery(name = "PersonalAddress.findAll", query = "SELECT p FROM PersonalAddress p")
public class PersonalAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String addressLine1;

	private String addressLine2;

	private Integer createdBy;

	private Date createdDate;

	private String landMark;

	private String pinCode;

	private Integer updatedBy;

	private Date updatedDate;

	// bi-directional many-to-one association to MasterCity
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "CityID")
	private MasterCity masterCity;

	// bi-directional many-to-one association to MasterCountry
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "CountryID")
	private MasterCountry masterCountry;

	// bi-directional many-to-one association to MasterState
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "StateID")
	private MasterState masterState;

	// bi-directional many-to-one association to UserInfomation
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "UserID")
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

	@Override
	public String toString() {
		return "PersonalAddress [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", landMark=" + landMark + ", pinCode="
				+ pinCode + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", masterCity=" + masterCity
				+ ", masterCountry=" + masterCountry + ", masterState=" + masterState + ", userInfomation="
				+ userInfomation + "]";
	}

	
}