package org.akcap.socialone.master.controller;

import java.util.List;

import org.akcap.socialone.entity.MasterCity;
import org.akcap.socialone.entity.MasterCountry;
import org.akcap.socialone.master.service.CityService;
import org.akcap.socialone.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@GetMapping(value = "/listCity")
	public ResponseEntity<ResponseMessage<MasterCity>> listGender() {
		ResponseMessage<MasterCity> response = new ResponseMessage<MasterCity>();
		List<MasterCity> genderList = cityService.getall();
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
