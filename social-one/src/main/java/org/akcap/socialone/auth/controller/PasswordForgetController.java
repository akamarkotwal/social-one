package org.akcap.socialone.auth.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.akcap.socialone.auth.service.PasswordForgetService;
import org.akcap.socialone.util.SingaleResponceMessages;
import org.akcap.socialone.verification.model.OTPDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/socialone")
public class PasswordForgetController {
	
	@Autowired
	private PasswordForgetService passwordForgetService;
	
	private static final Logger logger = (Logger) LogManager.getLogger(PasswordForgetController	.class);

	SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();
	@PostMapping("/forgetpass")
	public ResponseEntity<?> sendOtp(@RequestBody OTPDetails requestBodyotpDetails) throws AddressException, MessagingException, IOException{
		
		SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();
		
		String email = requestBodyotpDetails.getEmail();
		if (email == null || email.isEmpty()) {
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("please add the email");
			responseMessage.setData(null);

			return new ResponseEntity<>(responseMessage, HttpStatus.OK);
		} else {
			
		 String res=passwordForgetService.sendPassword(email);
		 if(res.contains("A")) {
			 responseMessage.setStatuscode(1);
				responseMessage.setStatus("Success");
				responseMessage.setMessage("email send sucessfully");
				responseMessage.setData(null);
		 }else {
			 responseMessage.setStatuscode(0);
				responseMessage.setStatus("Failed");
				responseMessage.setMessage("email is invalid");
				responseMessage.setData(null);

		 }
		}
		return null;
		
	}

}
