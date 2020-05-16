package org.akcap.socialone.userdetailes.serviceimpl;

import java.util.Date;
import java.util.List;


import org.akcap.socialone.auth.repo.UserRepo;
import org.akcap.socialone.entity.MasterGender;
import org.akcap.socialone.entity.UserInfomation;
import org.akcap.socialone.userdetailes.model.UserDTO;
import org.akcap.socialone.userdetailes.service.UserRegisterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterServices {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public UserInfomation saveUser(UserDTO userDTO) {
		UserInfomation infomation = new UserInfomation();
		infomation.setFname(userDTO.getFname());
		infomation.setLname(userDTO.getLname());
		infomation.setDob(userDTO.getDob());
		infomation.setUserName(userDTO.getEmail());
		infomation.setEmail(userDTO.getEmail());
		infomation.setCreatedDate(new Date());
		infomation.setUpdatedDate(new Date());
		infomation.setPassword(bcryptEncoder.encode(userDTO.getPassword()));
		infomation.setIsActive((byte) 1);
		infomation.setIsDelete((byte) 0);
		MasterGender gender = new MasterGender();
		gender.setId(userDTO.getGenderId());
		infomation.setMasterGender(gender);
		return userRepo.save(infomation);
		
		
		
	}

	@Override
	public UserInfomation updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfomation getUserDeatilsById(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(int Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserInfomation> getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfomation getEmail(String email) {
		
		return userRepo.findByEmail(email);
	}

}
