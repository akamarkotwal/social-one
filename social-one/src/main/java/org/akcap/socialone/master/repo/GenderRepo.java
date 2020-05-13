package org.akcap.socialone.master.repo;

import org.akcap.socialone.entity.MasterGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepo extends JpaRepository<MasterGender, Integer> {

}
