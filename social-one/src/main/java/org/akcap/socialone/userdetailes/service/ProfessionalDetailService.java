package org.akcap.socialone.userdetailes.service;

import java.util.List;

import org.akcap.socialone.entity.ProfessionalDetail;
import org.akcap.socialone.userdetailes.model.ProfessionalDetailDTO;
import org.springframework.stereotype.Component;

@Component
public interface ProfessionalDetailService {
	
	public ProfessionalDetail saveUpdate(ProfessionalDetailDTO professionalDetailDTO);
	
	public ProfessionalDetail getDetailes(int userID);
	
	public void deleteDetailes(int userID);
	
	public List<ProfessionalDetail> getAllDeatiles(int userID);

}
