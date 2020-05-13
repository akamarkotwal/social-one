package org.akcap.socialone.master.controller;

import java.util.List;

import org.akcap.socialone.entity.MasterGender;
import org.akcap.socialone.master.service.GenderService;
import org.akcap.socialone.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
public class GenderController {
	@Autowired
	private GenderService genderService;
	
	@GetMapping(value="/listGender")
	public ResponseEntity<ResponseMessage<MasterGender>> listGender(){
		ResponseMessage<MasterGender> response=new ResponseMessage<MasterGender>();
		List<MasterGender> genderList=genderService.getall();
		if(genderList.isEmpty()!=true) {
			response.setStatuscode(1);
			response.setStatus("Success");
			response.setMessage("Getting List of Gender Successfully");
			response.setData(genderList);
			return ResponseEntity.ok().body(response);
		}
		else {
			response.setStatuscode(0);
			response.setStatus("Failure");
			response.setMessage("Getting List of Gender Failed");
			response.setData(null);
			return ResponseEntity.ok().body(response);	
		}
	}
	
	

}
