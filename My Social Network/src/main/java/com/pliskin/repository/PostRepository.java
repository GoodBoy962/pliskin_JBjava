package com.pliskin.repository;

import com.pliskin.model.Post;
import com.pliskin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserPageOrderByDateDescTimeDesc(User user);

    Post findOne(Long id);

    @Transactional
    @Modifying
    @Query(value = "delete from Post p where p.id = :id")
    void delete(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Post p SET p.text = :text WHERE p.id = :postId")
    void updatePost(@Param("postId") Long id, @Param("text") String text);

}
