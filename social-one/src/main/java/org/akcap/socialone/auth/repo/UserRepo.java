package org.akcap.socialone.auth.repo;

import javax.persistence.QueryHint;

import org.akcap.socialone.entity.UserInfomation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInfomation, Integer> {
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	UserInfomation findByEmail(String email);
	
	@QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true"))
	UserInfomation findByuserName(String username);

	@Query(value="SELECT * FROM projectx.user_infomation where ID=?",nativeQuery = true)
	UserInfomation findByUserID(@Param("ID") int ID);
}
