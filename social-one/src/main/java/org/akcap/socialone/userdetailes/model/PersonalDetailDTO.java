package org.akcap.socialone.userdetailes.model;

import org.springframework.web.multipart.MultipartFile;

public class PersonalDetailDTO {

	private Integer userID;
	
	private String interested;

	private String language;

	private String mobileNo;

	private String movies;

	private MultipartFile profilePic;

	private String religiousViews;

	public PersonalDetailDTO() {
		super();
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getInterested() {
		return interested;
	}

	public void setInterested(String interested) {
		this.interested = interested;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMovies() {
		return movies;
	}

	public void setMovies(String movies) {
		this.movies = movies;
	}

	public MultipartFile getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(MultipartFile profilePic) {
		this.profilePic = profilePic;
	}

	public String getReligiousViews() {
		return religiousViews;
	}

	public void setReligiousViews(String religiousViews) {
		this.religiousViews = religiousViews;
	}
	
	

}
