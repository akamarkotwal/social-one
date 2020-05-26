package org.akcap.socialone.auth.repo;

import org.akcap.socialone.entity.PasswordForget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordForgetRepo extends JpaRepository<PasswordForget, Integer>{

  
}
