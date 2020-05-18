package org.akcap.socialone.master.serviceimpl;

import java.util.List;

import org.akcap.socialone.entity.MasterUniversity;
import org.akcap.socialone.master.repo.UniversityRepo;
import org.akcap.socialone.master.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityServiceImpl implements UniversityService{

	@Autowired
	private UniversityRepo universityRepo;
	
	@Override
	public List<MasterUniversity> getall() {
		// TODO Auto-generated method stub
		return universityRepo.findAll();
	}

}
