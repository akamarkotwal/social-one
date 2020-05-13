package org.akcap.socialone.master.service;

import java.util.List;

import org.akcap.socialone.entity.MasterGender;
import org.springframework.stereotype.Component;

@Component
public interface GenderService {
	public List<MasterGender> getall();

}
