package com.pliskin.service.impl;

import com.pliskin.annotations.ExceptionAnnotation;
import com.pliskin.annotations.TimeAnnotation;
import com.pliskin.model.Post;
import com.pliskin.model.User;
import com.pliskin.repository.PostRepository;
import com.pliskin.repository.UserRepository;
import com.pliskin.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PostServiceImpl implements PostService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Qualifier("postRepository")
    @Autowired
    private PostRepository postRepository;

    @Transactional
    @Override
    public void savePost(User user, String text) {
        Post post = new Post();
        //User u = userRepository.getOne(user.getId());
        User u = userRepository.findByUsername(user.getUsername());
        post.setUser(u);
        post.setUserPage(u);
        post.setText(text);
        post.setDate(new java.sql.Date((new java.util.Date()).getTime()));
        post.setTime(new java.sql.Time((new java.util.Date()).getTime()));
        postRepository.save(post);

    }

    @Override
    @Transactional
    public void savePost(User user, String friend, String text) {
        Post post = new Post();
        User userPage = userRepository.findByUsername(friend);
        User userAuthor = userRepository.findByUsername(user.getUsername());
        post.setUserPage(userPage);
        post.setUser(userAuthor);
        post.setText(text);
        post.setDate(new java.sql.Date((new java.util.Date()).getTime()));
        post.setTime(new java.sql.Time((new java.util.Date()).getTime()));
        postRepository.save(post);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    @TimeAnnotation
    @Override
    public List<Post> getAll(User user) {
        return postRepository.findByUserPage(user);
    }

    @Override
    public List<Post> getAll(String friend) {
        User userPage = userRepository.findOneByUsername(friend);
        return postRepository.findByUserPage(userPage);
    }

    @ExceptionAnnotation
    @Override
    public Exception throwException(User user) throws Exception {
        if (true) throw new RuntimeException("для отлова");
        return null;
    }
}
