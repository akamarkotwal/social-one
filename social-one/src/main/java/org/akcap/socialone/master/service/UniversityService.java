package org.akcap.socialone.master.service;

import java.util.List;

import org.akcap.socialone.entity.MasterUniversity;
import org.springframework.stereotype.Component;

@Component
public interface UniversityService {
	public List<MasterUniversity> getall();


}
