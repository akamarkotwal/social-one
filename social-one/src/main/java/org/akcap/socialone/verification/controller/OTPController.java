package org.akcap.socialone.verification.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.akcap.socialone.notification.EmailMessage;
import org.akcap.socialone.notification.EmailSend;
import org.akcap.socialone.util.SingaleResponceMessages;
import org.akcap.socialone.verification.model.OTPDetails;
import org.akcap.socialone.verification.service.OTPService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
public class OTPController {
	@Autowired
	private OTPService otpService;

	private static final Logger logger = (Logger) LogManager.getLogger(OTPController.class);

	SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();

	@PostMapping("/getotp")
	public ResponseEntity<?> sendOtp(@RequestBody OTPDetails requestBodyotpDetails)
			throws AddressException, MessagingException, IOException {
		SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();
		String email = requestBodyotpDetails.getEmail();
		if (email == null || email.isEmpty()) {
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("please add the email");
			responseMessage.setData(null);

			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {

			OTPDetails otpDetails = otpService.getOtp(email);

			EmailSend emailSend = new EmailSend();
			EmailMessage emailMessage = new EmailMessage();
			emailMessage.setSubject("OTP Verification");
			emailMessage.setBody(otpDetails.getOtp());
			emailMessage.setTo_address(email);

			emailSend.sendEmail(emailMessage);

			responseMessage.setStatuscode(1);
			responseMessage.setStatus("Success");
			responseMessage.setMessage("email send sucessfully");
			responseMessage.setData(otpDetails.getOtp());

			return new ResponseEntity<>(responseMessage, HttpStatus.OK);

		}

	}

	@PostMapping("/verifyotp")
	public ResponseEntity<Object> verifyOtp(@RequestBody OTPDetails requestBodyotpDetails) {

		if (requestBodyotpDetails.getOtp() == null || requestBodyotpDetails.getOtp().trim().length() <= 0) {
			logger.info("requestBodyOTPSystem is empty");
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("Please provide OTP");
			responseMessage.setData(null);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			String email = requestBodyotpDetails.getEmail();
			String res = otpService.verifyOtp(email, requestBodyotpDetails);
			if (res.contains("A")) {
				logger.info("OTP Verification Sucessfully");
				responseMessage.setStatuscode(1);
				responseMessage.setStatus("Success");
				responseMessage.setMessage("OTP Verification Sucessfully");
				responseMessage.setData(null);
				return new ResponseEntity<>(responseMessage, HttpStatus.OK);

			} else if (res.contains("B")) {
				logger.info("Invalid OTP");
				responseMessage.setStatuscode(0);
				responseMessage.setStatus("Failed");
				responseMessage.setMessage("Invalid OTP");
				responseMessage.setData(null);
				return new ResponseEntity<>(responseMessage, HttpStatus.OK);

			} else if (res.contains("C")) {
				logger.info("OTP is expired");
				responseMessage.setStatuscode(0);
				responseMessage.setStatus("Failed");
				responseMessage.setMessage("OTP is expired");
				responseMessage.setData(null);
				return new ResponseEntity<>(responseMessage, HttpStatus.OK);

			} else if (res.contains("D")) {
				logger.info("Something went wrong..!!");
				responseMessage.setStatuscode(0);
				responseMessage.setStatus("Failed");
				responseMessage.setMessage("Something went wrong..!!");
				responseMessage.setData(null);
				return new ResponseEntity<>(responseMessage, HttpStatus.OK);
			} else if (res.contains("E")) {
				logger.info("Mobile number not found");
				responseMessage.setStatuscode(0);
				responseMessage.setStatus("Failed");
				responseMessage.setMessage("Mobile number not found");
				responseMessage.setData(null);
				return new ResponseEntity<>(responseMessage, HttpStatus.OK);
			}
			logger.info("Unexpected  result ..!!");
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("Unexpected  result ..!!");
			responseMessage.setData(null);
			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		}

	}
}
