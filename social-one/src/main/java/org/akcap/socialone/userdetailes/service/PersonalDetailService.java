package org.akcap.socialone.userdetailes.service;

import java.io.IOException;
import java.util.List;

import org.akcap.socialone.entity.PersonalDetail;
import org.akcap.socialone.userdetailes.model.PersonalDetailDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface PersonalDetailService {
	public PersonalDetail saveUpdate(PersonalDetailDTO personalDetailDTO)throws IOException;
	
	public PersonalDetail findByUserId(int UserID);
	
	public List<PersonalDetail> findAll();
	
	public PersonalDetail uploadImages(int userId,MultipartFile file);
	


}
