package org.akcap.socialone.util;

public class OTPDetails {
	private String email;
	private String otp;
	private long expirytime;
	
	public OTPDetails() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public long getExpirytime() {
		return expirytime;
	}
	public void setExpirytime(long expirytime) {
		this.expirytime = expirytime;
	}
	
	

}
