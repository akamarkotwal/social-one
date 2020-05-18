package org.akcap.socialone.master.repo;

import java.util.List;

import javax.persistence.QueryHint;

import org.akcap.socialone.entity.MasterState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<MasterState, Integer> {
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	@Override
	List<MasterState> findAll() ;

}
