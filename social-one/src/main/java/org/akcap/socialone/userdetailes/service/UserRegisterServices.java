package org.akcap.socialone.userdetailes.service;

import java.util.List;


import org.akcap.socialone.entity.UserInfomation;
import org.akcap.socialone.userdetailes.model.UserDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserRegisterServices {
	public UserInfomation saveUser(UserDTO userDTO);
	
	public UserInfomation updateUser(UserDTO userDTO);
	
	
	public UserInfomation getUserDeatilsById(int Id);
	
	
	public void deleteUserById(int Id);
	
	public List<UserInfomation> getAllUser();
	
	
	public UserInfomation getEmail(String email);

}
