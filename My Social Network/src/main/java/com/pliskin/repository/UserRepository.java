package com.pliskin.repository;

import com.pliskin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByUsername(String username);

    User findOneByEmail(String email);

    List<User> findAll();

    @Query(value = "select u2 from User u, User u2 where u.username = :name and u.id = u2.id")
    User findUserByUserName(@Param("name") String name);

    User findByUsername(String username);

}
