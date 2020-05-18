package org.akcap.socialone.userdetailes;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.akcap.socialone.auth.repo.UserRepo;
import org.akcap.socialone.entity.MasterGender;
import org.akcap.socialone.entity.UserInfomation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)

public class UserRegistrationRepoTest {
	@Autowired
	private UserRepo repo;
	
	@Test
    public void testSaveUser() throws ParseException {
		UserInfomation infomation=new UserInfomation();
		infomation.setFname("amar");
		infomation.setLname("kotwal");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse("1989-05-06");
		infomation.setDob(date);
		infomation.setEmail("pkpooja@gmail.com");
		infomation.setPassword("admin");
		MasterGender gender=new MasterGender();
		gender.setId(1);
		infomation.setMasterGender(gender);
		repo.save(infomation);
		
		assertNotNull(infomation);
		
	}

}
