package org.akcap.socialone.userdetailes.controller;

import org.akcap.socialone.entity.ProfessionalDetail;
import org.akcap.socialone.userdetailes.model.PersonalAddressDTO;
import org.akcap.socialone.userdetailes.model.ProfessionalDetailDTO;
import org.akcap.socialone.userdetailes.service.ProfessionalDetailService;
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
public class ProfessionalDetailController {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(ProfessionalDetailController.class);

	@Autowired
	private ProfessionalDetailService service;

	@PostMapping(value = "/saveprofessionaldetail")
	public ResponseEntity<?> saveDeatiles(@RequestBody ProfessionalDetailDTO professionalDetailDTO) {
		SingaleResponceMessages<?> responseMessage = new SingaleResponceMessages<>();
		if (professionalDetailDTO == null) {

			LOGGER.error("Field is missing from body");
			responseMessage.setStatuscode(0);
			responseMessage.setStatus("Failed");
			responseMessage.setMessage("Please Provide All Details");
			responseMessage.setData(null);
			return ResponseEntity.ok(responseMessage);
		} else {
			ProfessionalDetail professionalDetail = service.saveUpdate(professionalDetailDTO);
			if (professionalDetail != null) {
				responseMessage.setStatuscode(1);
				responseMessage.setStatus("Success");
				responseMessage.setMessage("Professional Detail add Successfully");
				responseMessage.setData(null);
				return ResponseEntity.ok(responseMessage);

			} else {
				responseMessage.setStatuscode(0);
				responseMessage.setStatus("Failed");
				responseMessage.setMessage("UnSuccessfully");
				responseMessage.setData(null);
				return ResponseEntity.ok(responseMessage);
			}
		}
	}

}
