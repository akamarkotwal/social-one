package org.akcap.socialone.master.service;

import java.util.List;

import org.akcap.socialone.entity.MasterState;
import org.springframework.stereotype.Component;

@Component
public interface StateService {
	public List<MasterState> getall();

}
