package org.akcap.socialone.userdetailes.repo;

import javax.persistence.QueryHint;

import org.akcap.socialone.entity.Userlogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface UserloginRepo extends JpaRepository<Userlogin, Integer> {
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	Userlogin findByuserName(String username);

}
