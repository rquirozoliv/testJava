package com.concretesolutions.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.concretesolutions.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	User findOneByEmail(String email);
	User findOneByName(String name);
	
	@Query(nativeQuery = true,
			value = "SELECT usr.* FROM USER usr WHERE usr.email = ?1 AND usr.password = ?2")
	User findByEmailAndPassword(String email, String password);
	
}
