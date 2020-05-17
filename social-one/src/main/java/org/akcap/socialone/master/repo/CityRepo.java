package org.akcap.socialone.master.repo;

import org.akcap.socialone.entity.MasterCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<MasterCity, Integer> {
	

}
