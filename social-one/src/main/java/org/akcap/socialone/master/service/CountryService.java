package org.akcap.socialone.master.service;

import java.util.List;

import org.akcap.socialone.entity.MasterCountry;
import org.springframework.stereotype.Component;

@Component
public interface CountryService {

	public List<MasterCountry> getall();
}
