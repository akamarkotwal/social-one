package org.akcap.socialone.userdetailes.controller;

import org.akcap.socialone.entity.PersonalAddress;
import org.akcap.socialone.userdetailes.model.PersonalAddressDTO;
import org.akcap.socialone.userdetailes.model.UserDTO;
import org.akcap.socialone.userdetailes.model.UserResponse;
import org.akcap.socialone.userdetailes.service.PersonalAddressService;
import org.akcap.socialone.util.SingaleResponceMessages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
public class PersonalAddressController {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(PersonalAddressController.class);

	@Autowired
	private PersonalAddressService addressService;

	@PostMapping(value = "/saveaddress")
	public ResponseEntity<?> saveUser(@RequestBody PersonalAddressDTO addressDTO) throws Exception {
		SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();
		if (addressDTO.getUserID() != null) {

			
			PersonalAddress personalAddress = addressService.saveAddress(addressDTO);
			if (personalAddress != null) {
				UserResponse response = new UserResponse();
				response.setUserID(personalAddress.getUserInfomation().getId());
				//response.setUserName(personalAddress.getUserInfomation().getFname());
				responseMessage.setStatuscode(1);
				responseMessage.setStatus("Success");
				responseMessage.setMessage("Address Record Insert Successfully");
				responseMessage.setData(response);

				return ResponseEntity.ok(responseMessage);
			} else {
				responseMessage.setStatuscode(0);
				responseMessage.setStatus("Failed");
				responseMessage.setMessage("Address Record Insert UnSuccessfully");
				responseMessage.setData(null);
				return ResponseEntity.ok(responseMessage);
			}

			

		} else {
			LOGGER.error("Field is missing from body");
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("Please Provide All Details");
			responseMessage.setData(null);
			return ResponseEntity.ok(responseMessage);

		}
		

	}

}
