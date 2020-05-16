package org.akcap.socialone.master.controller;

import java.util.List;

import org.akcap.socialone.entity.MasterCountry;
import org.akcap.socialone.entity.MasterGender;
import org.akcap.socialone.master.service.CountryService;
import org.akcap.socialone.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
public class CountryController {
	@Autowired
	private CountryService countryService;

	@GetMapping(value = "/listCountry")
	public ResponseEntity<ResponseMessage<MasterCountry>> listGender() {
		ResponseMessage<MasterCountry> response = new ResponseMessage<MasterCountry>();
		List<MasterCountry> genderList = countryService.getall();
		if (genderList.isEmpty() != true) {
			response.setStatuscode(1);
			response.setStatus("Success");
			response.setMessage("Getting List of Country Successfully");
			response.setData(genderList);
			return ResponseEntity.ok().body(response);
		} else {
			response.setStatuscode(0);
			response.setStatus("Failure");
			response.setMessage("Getting List of Country Failed");
			response.setData(null);
			return ResponseEntity.ok().body(response);
		}
	}

}
