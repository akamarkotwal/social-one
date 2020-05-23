package org.akcap.socialone.userdetailes.serviceimpl;

import org.akcap.socialone.entity.Userlogin;
import org.akcap.socialone.userdetailes.repo.UserloginRepo;
import org.akcap.socialone.userdetailes.service.UserloginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserloginServiceImpl implements UserloginService{
	
	@Autowired
	private UserloginRepo userloginRepo;

	@Override
	public Userlogin findByUserLogin(String username) {
		// TODO Auto-generated method stub
		return userloginRepo.findByuserName(username);
	}

}
