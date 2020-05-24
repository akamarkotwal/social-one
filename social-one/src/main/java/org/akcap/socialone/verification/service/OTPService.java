package org.akcap.socialone.verification.service;


import org.akcap.socialone.verification.model.OTPDetails;
import org.springframework.stereotype.Component;

@Component
public interface OTPService {
	public OTPDetails getOtp(String email);
	
	public String verifyOtp(String email, OTPDetails otpDetails);

}
