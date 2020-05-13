package org.akcap.socialone.master.serviceimpl;

import java.util.List;

import org.akcap.socialone.entity.MasterGender;
import org.akcap.socialone.master.repo.GenderRepo;
import org.akcap.socialone.master.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService{
	
	@Autowired
	GenderRepo genderRepo;

	@Override
	public List<MasterGender> getall() {
		// TODO Auto-generated method stub
		return genderRepo.findAll();
	}

}
