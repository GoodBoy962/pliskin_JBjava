package com.pliskin.service.impl;

import com.pliskin.model.Post;
import com.pliskin.model.User;
import com.pliskin.repository.PostRepository;
import com.pliskin.repository.UserRepository;
import com.pliskin.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Qualifier("userRepository")
    @Autowired
    UserRepository userRepository;

    @Qualifier("postRepository")
    @Autowired
    PostRepository postRepository;

    @Transactional
    @Override
    public void savePost(User user, String text) {
        Post post = new Post();
        User u = userRepository.getOne(user.getId());
        post.setUser(u);
        post.setUserPage(u);
        post.setText(text);
        post.setDate(new java.sql.Date((new java.util.Date()).getTime()));
        post.setTime(new java.sql.Time((new java.util.Date()).getTime()));
        System.out.println(post.getText() + "   " + post.getUser().getUsername() + "   " + post.getTime() + "   " + post.getDate() + "   " + post.getUserPage().getUsername());
        postRepository.save(post);

    }

    @Override
    @Transactional
    public void savePost(User user, String friend, String text) {
        Post post = new Post();
        //User u = userRepository.findOne(user.getId());
        //post.setUser(u);
        System.out.println(friend);
        //User userPage = userRepository.getOne(userRep1ository.findOneByUsername(friend).getId());
        User ur = userRepository.findUserByUserName(friend);
        User user1 = userRepository.findOneByUsername(user.getUsername());
        //User user2 = userRepository.findOneByUsername(friend);
        post.setUserPage(ur);
        post.setUser(user1);
        //post.setUserPage(user2);
        //переделал так, потому что не сохраняло, когда делал первым способом, который закоменчен
        //если изменить, тоже ошибка, не мойму какая
        post.setText(text);
        post.setDate(new java.sql.Date((new java.util.Date()).getTime()));
        post.setTime(new java.sql.Time((new java.util.Date()).getTime()));
        postRepository.save(post);
        // а что не так?
        //сэйв не сработает
    }

    @Override
    public void deletePost(Post post) {

    }


    @Override
    public List<Post> getAll(User user) {
        return postRepository.findByUserPage(user);
    }

    @Override
    public List<Post> getAll(String friend) {
        User userPage = userRepository.findOneByUsername(friend);
        return postRepository.findByUserPage(userPage);
    }
}
