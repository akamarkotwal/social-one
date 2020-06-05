package org.akcap.socialone.userdetailes.controller;

import java.io.IOException;

import org.akcap.socialone.entity.PersonalDetail;
import org.akcap.socialone.userdetailes.model.PersonalDetailDTO;
import org.akcap.socialone.userdetailes.service.PersonalDetailService;
import org.akcap.socialone.util.SingaleResponceMessages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/socialone")
public class PersonalDetailController {

	private static final Logger LOGGER = (Logger) LogManager.getLogger(PersonalDetailController.class);
	@Autowired
	private PersonalDetailService personalDetailService;

	@PostMapping(value = "/savepersonaldetailes")
	public ResponseEntity<?> saveDetailes(@RequestBody PersonalDetailDTO personalDetailDTO) throws IOException {
		SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();
		if (personalDetailDTO != null) {
			PersonalDetail personalDetail = personalDetailService.saveUpdate(personalDetailDTO);
			if (personalDetail != null) {
				responseMessage.setStatuscode(1);
				responseMessage.setStatus("Success");
				responseMessage.setMessage("Personal Detailes  Save Successfully");
				responseMessage.setData(null);

				return ResponseEntity.ok(responseMessage);
			} else {
				responseMessage.setStatuscode(0);
				responseMessage.setStatus("Failed");
				responseMessage.setMessage("Personal Detailes UnSuccessfully");
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

	@PostMapping(value = "/uploadImg")
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file,
			@RequestParam("uid") Integer userId) {
		SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();
		if (file == null && userId == null) {
			LOGGER.error("Field is missing from body");
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("Please Provide All Details");
			responseMessage.setData(null);
			return ResponseEntity.ok(responseMessage);
		} else {
			PersonalDetail personalDetail = personalDetailService.uploadImages(userId, file);
			if (personalDetail != null) {
				responseMessage.setStatuscode(1);
				responseMessage.setStatus("Success");
				responseMessage.setMessage("Personal Detailes  Save Successfully");
				responseMessage.setData(null);

				return ResponseEntity.ok(responseMessage);
			}
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("User Not Found");
			responseMessage.setData(null);
			return ResponseEntity.ok(responseMessage);

		}
	}

	@GetMapping("/getbyid/{userID}")
	public ResponseEntity<?> getByUser(@PathVariable Integer userID) {
		SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();
		if ( userID == null) {
			LOGGER.error("Field is missing from body");
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("Please Provide User Id");
			responseMessage.setData(null);
			return ResponseEntity.ok(responseMessage);
		}
		else {
			PersonalDetail personalDetail = personalDetailService.findByUserId(userID);
			if (personalDetail != null) {
				responseMessage.setStatuscode(1);
				responseMessage.setStatus("Success");
				responseMessage.setMessage("Personal Detail Getting sucessfully");
				responseMessage.setData(personalDetail);

				return ResponseEntity.ok(responseMessage);
			}
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("User Not Found");
			responseMessage.setData(null);
			return ResponseEntity.ok(responseMessage);

		}

	}
}