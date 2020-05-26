package org.akcap.socialone.auth.serviceimpl;

import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.akcap.socialone.auth.repo.PasswordForgetRepo;
import org.akcap.socialone.auth.service.PasswordForgetService;
import org.akcap.socialone.entity.PasswordForget;
import org.akcap.socialone.entity.Userlogin;
import org.akcap.socialone.notification.EmailMessage;
import org.akcap.socialone.notification.EmailSend;
import org.akcap.socialone.userdetailes.repo.UserloginRepo;
import org.akcap.socialone.verification.model.OTPDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordForgetServiceImpl implements PasswordForgetService {

	@Autowired
	private PasswordForgetRepo passwordForgetRepo;

	@Autowired
	private UserloginRepo userloginRepo;

	@Override
	public String sendPassword(String username) throws AddressException, MessagingException, IOException {
		Userlogin userlogin = userloginRepo.findByuserName(username);
		if (userlogin != null) {
			
			OTPDetails otpDetails = new OTPDetails();
			otpDetails.setOtp(String.valueOf(((int) (Math.random() * (1000 - 100))) + 1000));
			otpDetails.setEmail(username);
			PasswordForget passwordForget2 = new PasswordForget();
			passwordForget2.setCreateBy(userlogin.getUserID());
			passwordForget2.setCreateDate(new Date());
			passwordForget2.setCreateDateTime(new Date());
			passwordForget2.setToken(otpDetails.getOtp());
			passwordForget2.setUpdateBy(userlogin.getUserID());
			passwordForget2.setUpdateDate(new Date());
			Userlogin userlogin2 = new Userlogin();
			userlogin2.setUserID(userlogin.getUserID());
			passwordForget2.setUserlogin(userlogin2);
			passwordForgetRepo.save(passwordForget2);
			EmailSend emailSend = new EmailSend();
			EmailMessage emailMessage = new EmailMessage();
			emailMessage.setSubject("Forget Password Code");
			emailMessage.setBody(otpDetails.getOtp());
			emailMessage.setTo_address(username);
			emailSend.sendEmail(emailMessage);
			return "A";

		}
		return "B";
	}
	

}
