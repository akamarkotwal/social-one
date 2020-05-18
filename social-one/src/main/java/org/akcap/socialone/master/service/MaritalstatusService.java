package org.akcap.socialone.master.service;

import java.util.List;

import org.akcap.socialone.entity.MasterMaritalstatus;
import org.springframework.stereotype.Component;

@Component
public interface MaritalstatusService {
	public List<MasterMaritalstatus> getall();
}
