package org.akcap.socialone.master.repo;

import org.akcap.socialone.entity.MasterCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo  extends JpaRepository<MasterCourse, Integer>{

}
