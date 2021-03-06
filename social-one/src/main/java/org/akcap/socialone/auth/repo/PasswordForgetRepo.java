package org.akcap.socialone.auth.repo;

import javax.persistence.QueryHint;

import org.akcap.socialone.entity.PasswordForget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PasswordForgetRepo extends JpaRepository<PasswordForget, Integer>{

	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	@Query(value="SELECT * FROM projectx.password_forget where UserID = ?", nativeQuery = true)
	public PasswordForget findByUserID(@Param("UserID") int UserID);
	
	
	@Modifying
    @Transactional 
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	@Query(value="delete from projectx.password_forget where UserID = ?", nativeQuery = true)
	public void deleteByRowId(@Param("UserID") int UserID);
	
	
}
