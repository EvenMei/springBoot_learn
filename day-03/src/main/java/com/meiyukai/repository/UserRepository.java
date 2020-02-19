package com.meiyukai.repository;

import com.meiyukai.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value = "userRepository")
public interface UserRepository extends JpaRepository<User, Long>  , JpaSpecificationExecutor<User> {

   // List<User> findAll();

}
