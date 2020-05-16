package org.akcap.socialone.master.serviceimpl;

import java.util.List;

import org.akcap.socialone.entity.MasterCountry;
import org.akcap.socialone.master.repo.CountryRepo;
import org.akcap.socialone.master.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl  implements CountryService{
	
	@Autowired
	private CountryRepo countryRepo;

	@Override
	public List<MasterCountry> getall() {
		// TODO Auto-generated method stub
		return countryRepo.findAll();
	}

}
