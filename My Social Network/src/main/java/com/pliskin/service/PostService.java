package com.pliskin.service;

import com.pliskin.model.Post;
import com.pliskin.model.User;

import java.util.List;

/**
 * Created by aleksandrpliskin on 30.10.15.
 */
public interface PostService {

    void savePost(User user, String text);

    void savePost(User user, String friend, String text);

    void deletePost(Long post);

    List<Post> getAll(User user);

    List<Post> getAll(String friend);

}
