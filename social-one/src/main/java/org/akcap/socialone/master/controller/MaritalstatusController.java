package org.akcap.socialone.master.controller;

import java.util.List;

import org.akcap.socialone.entity.MasterGender;
import org.akcap.socialone.entity.MasterMaritalstatus;
import org.akcap.socialone.master.service.MaritalstatusService;
import org.akcap.socialone.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
public class MaritalstatusController {

	@Autowired
	private MaritalstatusService maritalstatusService;
	
	@GetMapping(value="/listMaritalstatus")
	public ResponseEntity<ResponseMessage<MasterMaritalstatus>> listMaritalstatus(){
		ResponseMessage<MasterMaritalstatus> response=new ResponseMessage<MasterMaritalstatus>();
		List<MasterMaritalstatus> genderList=maritalstatusService.getall();
		if(genderList.isEmpty()!=true) {
			response.setStatuscode(1);
			response.setStatus("Success");
			response.setMessage("Getting List of Maritalstatus Successfully");
			response.setData(genderList);
			return ResponseEntity.ok().body(response);
		}
		else {
			response.setStatuscode(0);
			response.setStatus("Failure");
			response.setMessage("Getting List of Maritalstatus Failed");
			response.setData(null);
			return ResponseEntity.ok().body(response);	
		}
}
}
