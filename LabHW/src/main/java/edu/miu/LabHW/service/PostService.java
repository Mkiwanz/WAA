package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findAllById(long id);

    void deleteById(long id);

    void updateById(int id,Post post);

    List<Post> findAllByTitleEquals(String title);

    List<Post> findPostByUser_Id(long id);


    Post findPostByUsers_IdAndId(long id, long post_id);

    void addUserPost(long user_id,Post post);

}
