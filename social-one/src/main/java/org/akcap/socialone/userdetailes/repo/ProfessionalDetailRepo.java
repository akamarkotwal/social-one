package org.akcap.socialone.userdetailes.repo;

import javax.persistence.QueryHint;

import org.akcap.socialone.entity.ProfessionalDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalDetailRepo extends JpaRepository<ProfessionalDetail, Integer> {
	
	
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	@Query(value="SELECT * FROM projectx.professional_details where UserID = ? ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public ProfessionalDetail findByUserID(int userID);

}
