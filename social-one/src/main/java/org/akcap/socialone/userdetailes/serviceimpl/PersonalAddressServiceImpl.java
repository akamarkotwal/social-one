package org.akcap.socialone.userdetailes.serviceimpl;

import java.util.Date;
import java.util.List;

import org.akcap.socialone.entity.MasterCity;
import org.akcap.socialone.entity.MasterCountry;
import org.akcap.socialone.entity.MasterState;
import org.akcap.socialone.entity.PersonalAddress;
import org.akcap.socialone.entity.UserInfomation;
import org.akcap.socialone.userdetailes.model.PersonalAddressDTO;
import org.akcap.socialone.userdetailes.repo.PersonalAddressRepo;
import org.akcap.socialone.userdetailes.service.PersonalAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalAddressServiceImpl implements PersonalAddressService {

	@Autowired
	private PersonalAddressRepo addressRepo;

	@Override
	public PersonalAddress saveAddress(PersonalAddressDTO addressDTO) {
		PersonalAddress personalAddress = addressRepo.findByUserID(addressDTO.getUserID());
	

		if (personalAddress.getAddressLine1().equals(addressDTO.getAddressLine1())
				&& personalAddress.getAddressLine2().equals(addressDTO.getAddressLine2())
				&& personalAddress.getLandMark().equals(addressDTO.getLandMark())
				&& personalAddress.getPinCode().equals(addressDTO.getPinCode())
				&& personalAddress.getMasterCity().getId() == addressDTO.getCityID()
				&& personalAddress.getMasterState().getId() == addressDTO.getStateID()
				&& personalAddress.getMasterCountry().getId() == addressDTO.getCountryID()) {

			PersonalAddress address = new PersonalAddress();
			address.setId(personalAddress.getId());
			address.setAddressLine1(addressDTO.getAddressLine1());
			address.setAddressLine2(addressDTO.getAddressLine2());

			address.setLandMark(addressDTO.getLandMark());
			address.setPinCode(addressDTO.getPinCode());
			address.setUpdatedBy(addressDTO.getUserID());
			address.setUpdatedDate(new Date());
			UserInfomation infomation = new UserInfomation();
			infomation.setId(addressDTO.getUserID());
			address.setUserInfomation(infomation);
			MasterCity city = new MasterCity();
			city.setId(addressDTO.getCityID());
			address.setMasterCity(city);
			MasterState state = new MasterState();
			state.setId(addressDTO.getStateID());
			address.setMasterState(state);
			MasterCountry country = new MasterCountry();
			country.setId(addressDTO.getCountryID());
			address.setMasterCountry(country);

			return addressRepo.save(address);

		}

		PersonalAddress address = new PersonalAddress();
		address.setAddressLine1(addressDTO.getAddressLine1());
		address.setAddressLine2(addressDTO.getAddressLine2());
		address.setCreatedBy(addressDTO.getUserID());
		address.setCreatedDate(new Date());
		address.setLandMark(addressDTO.getLandMark());
		address.setPinCode(addressDTO.getPinCode());
		address.setUpdatedBy(addressDTO.getUserID());
		address.setUpdatedDate(new Date());
		UserInfomation infomation = new UserInfomation();
		infomation.setId(addressDTO.getUserID());
		address.setUserInfomation(infomation);
		MasterCity city = new MasterCity();
		city.setId(addressDTO.getCityID());
		address.setMasterCity(city);
		MasterState state = new MasterState();
		state.setId(addressDTO.getStateID());
		address.setMasterState(state);
		MasterCountry country = new MasterCountry();
		country.setId(addressDTO.getCountryID());
		address.setMasterCountry(country);

		return addressRepo.save(address);
	}

	@Override
	public PersonalAddress updateAddress(PersonalAddressDTO addressDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonalAddress getAddressDeatilsByUserId(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAddressByUserId(int Id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PersonalAddress> getAllAddress() {
		// TODO Auto-generated method stub
		return null;
	}

}
