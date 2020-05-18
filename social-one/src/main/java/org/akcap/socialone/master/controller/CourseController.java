package org.akcap.socialone.master.controller;

import java.util.List;

import org.akcap.socialone.entity.MasterCity;
import org.akcap.socialone.entity.MasterCourse;
import org.akcap.socialone.master.service.CourseService;
import org.akcap.socialone.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socialone")
@PreAuthorize("hasRole('ADMIN')")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping(value = "/listCourse")
	public ResponseEntity<ResponseMessage<MasterCourse>> listGender() {
		ResponseMessage<MasterCourse> response = new ResponseMessage<MasterCourse>();
		List<MasterCourse> genderList = courseService.getall();
		if (genderList.isEmpty() != true) {
			response.setStatuscode(1);
			response.setStatus("Success");
			response.setMessage("Getting List of Course Successfully");
			response.setData(genderList);
			return ResponseEntity.ok().body(response);
		} else {
			response.setStatuscode(0);
			response.setStatus("Failure");
			response.setMessage("Getting List of Course Failed");
			response.setData(null);
			return ResponseEntity.ok().body(response);
		}
	}

}


