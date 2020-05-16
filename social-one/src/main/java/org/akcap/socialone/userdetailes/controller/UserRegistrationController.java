package org.akcap.socialone.userdetailes.controller;

import org.akcap.socialone.auth.model.UserResponse;
import org.akcap.socialone.entity.UserInfomation;
import org.akcap.socialone.userdetailes.model.UserDTO;
import org.akcap.socialone.userdetailes.service.UserRegisterServices;
import org.akcap.socialone.util.SingaleResponceMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
public class UserRegistrationController {

	@Autowired
	private UserRegisterServices userRegisterServices;

	@PostMapping(value = "/register")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();
		UserInfomation userInfomation = userRegisterServices.getEmail(user.getEmail());
		if (userInfomation != null) {
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("User Email Alredy Register With Different Account");
			responseMessage.setData(null);
			return ResponseEntity.ok(responseMessage);
		}

		UserInfomation infomation = userRegisterServices.saveUser(user);

		if (infomation != null) {
			UserResponse response = new UserResponse();
			response.setUserID(infomation.getId());
			response.setUserName(infomation.getUserName());
			responseMessage.setStatuscode(1);
			responseMessage.setStatus("Success");
			responseMessage.setMessage("User Record Insert Successfully");
			responseMessage.setData(response);

			return ResponseEntity.ok(responseMessage);
		} else {
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("User Record Insert UnSuccessfully");
			responseMessage.setData(null);
			return ResponseEntity.ok(responseMessage);
		}

	}

}
