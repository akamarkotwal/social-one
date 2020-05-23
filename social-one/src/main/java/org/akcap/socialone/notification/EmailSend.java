package org.akcap.socialone.notification;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.akcap.socialone.verification.model.EmailMessage;
import org.springframework.beans.factory.annotation.Value;

public class EmailSend {
	@Value("${gmail.username}")
	private String username;
	@Value("${gmail.password}")
	private String password;

	
	public void sendEmail(EmailMessage emailMessage) throws AddressException, MessagingException, IOException{
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username, false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailMessage.getTo_address()));
		msg.setSubject(emailMessage.getSubject());
		msg.setContent(emailMessage.getBody(), "text/html");
		msg.setSentDate(new Date());
		Transport.send(msg);
		
	}

}
