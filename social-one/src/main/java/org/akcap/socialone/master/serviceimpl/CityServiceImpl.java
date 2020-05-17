package org.akcap.socialone.master.serviceimpl;

import java.util.List;

import org.akcap.socialone.entity.MasterCity;
import org.akcap.socialone.master.repo.CityRepo;
import org.akcap.socialone.master.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepo cityRepo;

	@Override
	
	public List<MasterCity> getall() {
		// TODO Auto-generated method stub
		
		return cityRepo.findAll();
	}

}
