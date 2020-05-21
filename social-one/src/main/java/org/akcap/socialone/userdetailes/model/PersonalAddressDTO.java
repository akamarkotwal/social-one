package org.akcap.socialone.userdetailes.model;

import java.io.Serializable;

public class PersonalAddressDTO implements Serializable{

	private static final long serialVersionUID = 6640327140929845708L;

	
	

	private Integer userID;
	
	private String addressLine1;

	private String addressLine2;
	
	private String landMark;

	private String pinCode;
	
	private Integer cityID;
	
	private Integer countryID;
	
	private Integer stateID;



	public PersonalAddressDTO() {
		super();
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Integer getCityID() {
		return cityID;
	}

	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}

	public Integer getCountryID() {
		return countryID;
	}

	public void setCountryID(Integer countryID) {
		this.countryID = countryID;
	}

	public Integer getStateID() {
		return stateID;
	}

	public void setStateID(Integer stateID) {
		this.stateID = stateID;
	}

	@Override
	public String toString() {
		return "PersonalAddressDTO [userID=" + userID + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", landMark=" + landMark + ", pinCode=" + pinCode + ", cityID=" + cityID
				+ ", countryID=" + countryID + ", stateID=" + stateID + "]";
	}



	
	

}
