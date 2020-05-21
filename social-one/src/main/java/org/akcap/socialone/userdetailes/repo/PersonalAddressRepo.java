package org.akcap.socialone.userdetailes.repo;

import javax.persistence.QueryHint;

import org.akcap.socialone.entity.PersonalAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalAddressRepo extends JpaRepository<PersonalAddress, Integer>{

	@Override
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	public PersonalAddress save(PersonalAddress address) ;
	
	
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	@Query(value="SELECT * FROM projectx.personal_address where UserID = ?", nativeQuery = true)
	public PersonalAddress findByUserID(@Param("UserID") int UserID);
	
	
	
	

}
