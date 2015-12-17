package com.pliskin.repository;

import com.pliskin.model.Post;
import com.pliskin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserPage(User user);

    Post findOneBy(Long id);


}
