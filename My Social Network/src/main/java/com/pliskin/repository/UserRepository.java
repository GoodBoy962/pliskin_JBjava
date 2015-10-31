package com.pliskin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pliskin.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByUsername(String username);

    User findOneByEmail(String email);

    List<User> findAll();

}
