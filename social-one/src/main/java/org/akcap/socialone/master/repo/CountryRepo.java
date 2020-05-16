package org.akcap.socialone.master.repo;

import org.akcap.socialone.entity.MasterCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<MasterCountry, Integer> {

}
