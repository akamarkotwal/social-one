package org.akcap.socialone.userdetailes.service;

import org.akcap.socialone.entity.Userlogin;
import org.springframework.stereotype.Component;

@Component
public interface UserloginService {
	Userlogin findByUserLogin(String username);

}
