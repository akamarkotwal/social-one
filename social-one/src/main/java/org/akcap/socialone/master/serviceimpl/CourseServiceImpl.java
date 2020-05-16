package org.akcap.socialone.master.serviceimpl;

import java.util.List;

import org.akcap.socialone.entity.MasterCourse;
import org.akcap.socialone.master.repo.CourseRepo;
import org.akcap.socialone.master.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo courseRepo;
	
	@Override
	public List<MasterCourse> getall() {
		
		return courseRepo.findAll();
	}

}
