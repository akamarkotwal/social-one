package org.akcap.socialone.master.controller;

import java.util.List;

import org.akcap.socialone.entity.MasterMaritalstatus;
import org.akcap.socialone.entity.MasterState;
import org.akcap.socialone.master.service.StateService;
import org.akcap.socialone.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
public class StateController {
	
	@Autowired
	private StateService stateService;
	
	@GetMapping(value="/listState")
	public ResponseEntity<ResponseMessage<MasterState>> listState(){
		ResponseMessage<MasterState> response=new ResponseMessage<MasterState>();
		List<MasterState> genderList=stateService.getall();
		if(genderList.isEmpty()!=true) {
			response.setStatuscode(1);
			response.setStatus("Success");
			response.setMessage("Getting List of State Successfully");
			response.setData(genderList);
			return ResponseEntity.ok().body(response);
		}
		else {
			response.setStatuscode(0);
			response.setStatus("Failure");
			response.setMessage("Getting List of State Failed");
			response.setData(null);
			return ResponseEntity.ok().body(response);	
		}
}

}
