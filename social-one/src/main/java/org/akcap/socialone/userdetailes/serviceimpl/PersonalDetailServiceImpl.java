package org.akcap.socialone.userdetailes.serviceimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.akcap.socialone.entity.PersonalDetail;
import org.akcap.socialone.entity.UserInfomation;
import org.akcap.socialone.userdetailes.model.PersonalDetailDTO;
import org.akcap.socialone.userdetailes.repo.PersonalDetailRepo;
import org.akcap.socialone.userdetailes.service.PersonalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PersonalDetailServiceImpl implements PersonalDetailService {

	@Autowired
	private PersonalDetailRepo personalDetailRepo;

	@Override
	public PersonalDetail saveUpdate(PersonalDetailDTO personalDetailDTO) throws IOException {
		PersonalDetail personalDetail = new PersonalDetail();

		personalDetail.setCreatedBy(personalDetailDTO.getUserID());
		personalDetail.setCreatedDate(new Date());
		personalDetail.setInterested(personalDetailDTO.getInterested());
		personalDetail.setLanguage(personalDetailDTO.getLanguage());
		personalDetail.setMobileNo(personalDetailDTO.getMobileNo());
		personalDetail.setMovies(personalDetailDTO.getMovies());
		personalDetail.setReligiousViews(personalDetailDTO.getReligiousViews());
		personalDetail.setProfilePic(PersonalDetailServiceImpl.ImageUpload(personalDetailDTO.getProfilePic()));
		personalDetail.setUpdatedBy(personalDetailDTO.getUserID());
		personalDetail.setUpdatedDate(new Date());
		UserInfomation infomation = new UserInfomation();
		infomation.setId(personalDetailDTO.getUserID());
		personalDetail.setUserInfomation(infomation);

		PersonalDetail detail = personalDetailRepo.save(personalDetail);

		return detail;
	}

	@Override
	public PersonalDetail findByUserId(int UserID) {
		return personalDetailRepo.findByUserID(UserID);

	}

	@Override
	public List<PersonalDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String ImageUpload(MultipartFile file) throws IOException {
		File convertFile = new File("C:\\Users\\amar.kotwal\\Documents\\ProfileImages\\" + file.getOriginalFilename());
		convertFile.createNewFile();
		String fname = convertFile.getPath();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return fname;

	}

	@Override
	public PersonalDetail uploadImages(int userId, MultipartFile file) {
		PersonalDetail personalDetail = personalDetailRepo.findByUserID(userId);
		if (personalDetail != null) {
			PersonalDetail detail = new PersonalDetail();
			detail.setId(personalDetail.getId());
			detail.setCreatedBy(personalDetail.getCreatedBy());
			detail.setCreatedDate(personalDetail.getCreatedDate());
			detail.setInterested(personalDetail.getInterested());
			detail.setLanguage(personalDetail.getLanguage());
			detail.setMobileNo(personalDetail.getMobileNo());
			detail.setUserInfomation(personalDetail.getUserInfomation());
			detail.setReligiousViews(personalDetail.getReligiousViews());
			detail.setMovies(personalDetail.getMovies());
			detail.setUpdatedBy(personalDetail.getUpdatedBy());
			detail.setUpdatedDate(new Date());
			try {
				String imageAdress = PersonalDetailServiceImpl.ImageUpload(file);
				detail.setProfilePic(imageAdress);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return personalDetailRepo.save(detail);
		}

		return null;
	}
}
