package org.akcap.socialone.verification.serviceimpl;

import java.util.HashMap;

import org.akcap.socialone.verification.model.OTPDetails;
import org.akcap.socialone.verification.service.OTPService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OTPServiceImpl implements OTPService {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(OTPServiceImpl.class);

	public final static HashMap<String, OTPDetails> OTP_DATA = new HashMap<>();

	public OTPDetails getOtp(String email) {
		OTPDetails otpDetails = new OTPDetails();
		otpDetails.setEmail(email);
		otpDetails.setOtp(String.valueOf(((int) (Math.random() * (1000 - 100))) + 1000));
		otpDetails.setExpirytime(System.currentTimeMillis() + 500000);
		OTPServiceImpl.OTP_DATA.put(email, otpDetails);
		LOGGER.info("otp in created of email=" + OTP_DATA.get(email));
		return otpDetails;

	}

	public String verifyOtp(String email, OTPDetails otpDetails) {
		OTPDetails otpDetails2 = new OTPDetails();
		if (OTPServiceImpl.OTP_DATA.containsKey(email)) {
			otpDetails2 = OTPServiceImpl.OTP_DATA.get(email);
			if (otpDetails2 != null) {
				if (otpDetails2.getExpirytime() >= System.currentTimeMillis()) {
					if (otpDetails2.getOtp().equals(otpDetails.getOtp())) {
						LOGGER.info("otp verification sucessfully");
						return "A";
					}
					LOGGER.info("Invalid OTP");
					return "B";
				}
				LOGGER.info("OTP is expired");
				return "C";

			}
			LOGGER.info("Something went wrong..!!");
			return "D";

		}
		LOGGER.info("Email  not found!");
		return "D";
	}

	


}
