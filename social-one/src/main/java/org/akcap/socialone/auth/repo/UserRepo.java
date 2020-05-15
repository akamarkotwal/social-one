package org.akcap.socialone.auth.repo;

import org.akcap.socialone.entity.UserInfomation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInfomation, Integer> {
	UserInfomation findByEmail(String email);
	UserInfomation findByuserName(String username);

}
