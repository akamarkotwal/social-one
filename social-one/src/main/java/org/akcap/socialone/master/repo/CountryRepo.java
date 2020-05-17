package org.akcap.socialone.master.repo;

import java.util.List;

import javax.persistence.QueryHint;

import org.akcap.socialone.entity.MasterCity;
import org.akcap.socialone.entity.MasterCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<MasterCountry, Integer> {
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	@Override
	List<MasterCountry> findAll() ;

}
