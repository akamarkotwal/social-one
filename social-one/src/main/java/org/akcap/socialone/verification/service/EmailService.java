package org.akcap.socialone.verification.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.akcap.socialone.verification.model.EmailMessage;

import org.springframework.stereotype.Component;

@Component
public interface EmailService {
	public void sendEmail(EmailMessage emailMessage) throws AddressException, MessagingException, IOException;
	
	public String verfiyEmail();

}
