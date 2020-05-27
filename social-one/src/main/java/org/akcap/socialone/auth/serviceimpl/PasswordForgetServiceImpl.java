package org.akcap.socialone.auth.serviceimpl;

import java.io.IOException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.akcap.socialone.auth.model.PassordReq;
import org.akcap.socialone.auth.repo.PasswordForgetRepo;
import org.akcap.socialone.auth.service.PasswordForgetService;
import org.akcap.socialone.entity.PasswordForget;
import org.akcap.socialone.entity.Userlogin;
import org.akcap.socialone.notification.EmailMessage;
import org.akcap.socialone.notification.EmailSend;
import org.akcap.socialone.userdetailes.repo.UserloginRepo;
import org.akcap.socialone.verification.model.OTPDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordForgetServiceImpl implements PasswordForgetService {

	@Autowired
	private PasswordForgetRepo passwordForgetRepo;

	@Autowired
	private UserloginRepo userloginRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public String sendPassword(String username) throws AddressException, MessagingException, IOException {
		Userlogin userlogin = userloginRepo.findByuserName(username);
		PasswordForget passwordForget2 = new PasswordForget();
		if (userlogin != null) {
			OTPDetails otpDetails = new OTPDetails();
			otpDetails.setOtp(String.valueOf(((int) (Math.random() * (1000 - 100))) + 1000));
			otpDetails.setEmail(username);
			PasswordForget forget = passwordForgetRepo.findByUserID(userlogin.getUserID());
			if (forget != null) {
				passwordForget2.setId(forget.getId());
				passwordForget2.setCreateBy(forget.getCreateBy());
				passwordForget2.setCreateDate(forget.getCreateDate());
				passwordForget2.setCreateDateTime(new Date());
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

	@Override
	public String ChangePassword(PassordReq passordReq) {
		System.out.println("otp="+passordReq.getOtp()+"email="+passordReq.getEmail());
		Userlogin userlogin = userloginRepo.findByuserName(passordReq.getEmail());
		if (userlogin != null) {
			PasswordForget passwordForget = passwordForgetRepo.findByUserID(userlogin.getUserID());
			if (passordReq.getOtp().equals(passwordForget.getToken())) {
				Userlogin userlogin2 = new Userlogin();
				userlogin2.setUserID(userlogin.getUserID());
				userlogin2.setCreatedAt(userlogin.getCreatedAt());
				userlogin2.setIsActive(userlogin.getIsActive());
				userlogin2.setIsDelete(userlogin.getIsDelete());
				userlogin2.setUserName(userlogin.getUserName());
				userlogin2.setUserInfomation(userlogin.getUserInfomation());
				userlogin2.setPassword(bcryptEncoder.encode(passordReq.getPassword()));
				userlogin2.setModifiedAt(new Date());
				userloginRepo.save(userlogin2);

				passwordForgetRepo.deleteById(passwordForget.getId());
				return "A";
			}
			return "B";
		}

		return "C";
	}

}
