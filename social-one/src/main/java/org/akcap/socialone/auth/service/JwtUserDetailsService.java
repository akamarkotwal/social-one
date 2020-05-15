package org.akcap.socialone.auth.service;

import java.util.ArrayList;
import java.util.Date;

import org.akcap.socialone.auth.model.UserDTO;
import org.akcap.socialone.auth.repo.UserRepo;
import org.akcap.socialone.entity.MasterGender;
import org.akcap.socialone.entity.UserInfomation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserInfomation user = userRepo.findByuserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				new ArrayList<>());

	}

	public UserInfomation save(UserDTO userDTO) {

		UserInfomation infomation1 = userRepo.findByEmail(userDTO.getEmail());
		if (infomation1 != null) {
			System.out.println("record alredy exists");

		}

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
}
