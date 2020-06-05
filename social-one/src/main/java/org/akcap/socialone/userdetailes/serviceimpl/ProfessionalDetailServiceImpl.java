package org.akcap.socialone.userdetailes.serviceimpl;

import java.util.Date;
import java.util.List;

import org.akcap.socialone.entity.MasterCity;
import org.akcap.socialone.entity.ProfessionalDetail;
import org.akcap.socialone.entity.UserInfomation;
import org.akcap.socialone.userdetailes.model.ProfessionalDetailDTO;
import org.akcap.socialone.userdetailes.repo.ProfessionalDetailRepo;
import org.akcap.socialone.userdetailes.service.ProfessionalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalDetailServiceImpl implements ProfessionalDetailService {

	@Autowired
	private ProfessionalDetailRepo professionalDetailRepo;

	@Override
	public ProfessionalDetail saveUpdate(ProfessionalDetailDTO professionalDetailDTO) {
		ProfessionalDetail detail = professionalDetailRepo.findByUserID(professionalDetailDTO.getUserID());
		System.out.println(detail);
		if (detail != null) {

			if (professionalDetailDTO.getUserID() == detail.getUserInfomation().getId()
					&& professionalDetailDTO.getCityID() == detail.getMasterCity().getId()
					&& professionalDetailDTO.getDescription().contentEquals(detail.getDescription())
					&& professionalDetailDTO.getOrganization().contentEquals(detail.getOrganization()) 
					&& professionalDetailDTO.getPosition().contentEquals(detail.getPosition())
					&& professionalDetailDTO.getStartDate() == detail.getStartDate()
					&& professionalDetailDTO.getEndDate() == detail.getEndDate()) {

				return detail;
			}
		}

		ProfessionalDetail professionalDetail = new ProfessionalDetail();
		professionalDetail.setCreatedBy(professionalDetailDTO.getUserID());
		professionalDetail.setCreatedDate(new Date());
		professionalDetail.setDescription(professionalDetailDTO.getDescription());
		professionalDetail.setOrganization(professionalDetailDTO.getOrganization());
		professionalDetail.setPosition(professionalDetailDTO.getPosition());
		professionalDetail.setStartDate(professionalDetailDTO.getStartDate());
		professionalDetail.setEndDate(professionalDetailDTO.getEndDate());
		professionalDetail.setUpdatedBy(professionalDetailDTO.getUserID());
		professionalDetail.setUpdatedDate(new Date());
		MasterCity city = new MasterCity();
		city.setId(professionalDetailDTO.getCityID());
		professionalDetail.setMasterCity(city);
		UserInfomation infomation = new UserInfomation();
		infomation.setId(professionalDetailDTO.getUserID());
		professionalDetail.setUserInfomation(infomation);

		return professionalDetailRepo.save(professionalDetail);
	}

	@Override
	public ProfessionalDetail getDetailes(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDetailes(int userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProfessionalDetail> getAllDeatiles(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
