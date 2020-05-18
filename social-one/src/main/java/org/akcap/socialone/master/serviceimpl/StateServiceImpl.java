package org.akcap.socialone.master.serviceimpl;

import java.util.List;

import org.akcap.socialone.entity.MasterState;
import org.akcap.socialone.master.repo.StateRepo;
import org.akcap.socialone.master.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepo stateRepo;
	
	@Override
	public List<MasterState> getall() {
		// TODO Auto-generated method stub
		return stateRepo.findAll();
	}

}
