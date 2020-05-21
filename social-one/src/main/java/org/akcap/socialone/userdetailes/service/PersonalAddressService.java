package org.akcap.socialone.userdetailes.service;

import java.util.List;

import org.akcap.socialone.entity.PersonalAddress;
import org.akcap.socialone.userdetailes.model.PersonalAddressDTO;
import org.springframework.stereotype.Component;

@Component
public interface PersonalAddressService {
public PersonalAddress saveAddress(PersonalAddressDTO addressDTO);
	
	public PersonalAddress updateAddress(PersonalAddressDTO addressDTO);
	
	
	public PersonalAddress getAddressDeatilsByUserId(int Id);
	
	
	public void deleteAddressByUserId(int Id);
	
	public List<PersonalAddress> getAllAddress();
	
	
	

}
