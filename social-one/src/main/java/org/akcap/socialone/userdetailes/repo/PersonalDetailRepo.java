package org.akcap.socialone.userdetailes.repo;

import javax.persistence.QueryHint;

import org.akcap.socialone.entity.PersonalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalDetailRepo extends JpaRepository<PersonalDetail, Integer>{
	
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	@Query(value="SELECT * FROM projectx.personal_details where UserID = ? ORDER BY id DESC LIMIT 1",nativeQuery = true) 
	public PersonalDetail findByUserID(@Param("UserID") int UserID);

}
