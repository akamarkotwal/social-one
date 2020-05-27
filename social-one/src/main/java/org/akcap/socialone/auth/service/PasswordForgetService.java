package org.akcap.socialone.auth.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.akcap.socialone.auth.model.PassordReq;
import org.akcap.socialone.entity.PasswordForget;
import org.springframework.stereotype.Component;

@Component
public interface PasswordForgetService {


	
	
	public String sendPassword(String username) throws AddressException, MessagingException, IOException;
	
	public String ChangePassword(PassordReq passordReq);

}
