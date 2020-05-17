package org.akcap.socialone.master.service;

import java.util.List;

import org.akcap.socialone.entity.MasterCity;
import org.springframework.stereotype.Component;

@Component
public interface CityService {
	
	public List<MasterCity> getall();

}
