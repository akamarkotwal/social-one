package org.akcap.socialone.master.service;

import java.util.List;

import org.akcap.socialone.entity.MasterCourse;
import org.springframework.stereotype.Component;

@Component
public interface CourseService {
	public List<MasterCourse> getall();

}
