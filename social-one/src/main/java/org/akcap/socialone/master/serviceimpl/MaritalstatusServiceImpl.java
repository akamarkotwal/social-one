package org.akcap.socialone.master.serviceimpl;

import java.util.List;

import org.akcap.socialone.entity.MasterMaritalstatus;
import org.akcap.socialone.master.repo.MaritalstatusRepo;
import org.akcap.socialone.master.service.MaritalstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaritalstatusServiceImpl implements MaritalstatusService {

	@Autowired
	private MaritalstatusRepo maritalstatusRepo;
	
	@Override
	public List<MasterMaritalstatus> getall() {
		
		return maritalstatusRepo.findAll();
	}

}
