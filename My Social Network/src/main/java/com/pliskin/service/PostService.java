package com.pliskin.service;

import com.pliskin.model.Post;
import com.pliskin.model.User;
import javafx.geometry.Pos;

import java.util.List;

/**
 * Created by aleksandrpliskin on 30.10.15.
 */
public interface PostService {

    void savePost(User user, String text);

    void deletePost(Post post);

    void changePost(Post post);

    List<Post> getAll(User user);

}
