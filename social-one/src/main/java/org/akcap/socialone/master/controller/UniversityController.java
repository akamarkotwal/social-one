package org.akcap.socialone.master.controller;

import java.util.List;

import org.akcap.socialone.entity.MasterState;
import org.akcap.socialone.entity.MasterUniversity;
import org.akcap.socialone.master.service.UniversityService;
import org.akcap.socialone.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
public class UniversityController {
	@Autowired
	private UniversityService universityService;
	
	@GetMapping(value="/listUniversity")
	public ResponseEntity<ResponseMessage<MasterUniversity>> listUniversity(){
		ResponseMessage<MasterUniversity> response=new ResponseMessage<MasterUniversity>();
		List<MasterUniversity> genderList=universityService.getall();
		if(genderList.isEmpty()!=true) {
			response.setStatuscode(1);
			response.setStatus("Success");
			response.setMessage("Getting List of University Successfully");
			response.setData(genderList);
			return ResponseEntity.ok().body(response);
		}
		else {
			response.setStatuscode(0);
			response.setStatus("Failure");
			response.setMessage("Getting List of University Failed");
			response.setData(null);
			return ResponseEntity.ok().body(response);	
		}
}

}
