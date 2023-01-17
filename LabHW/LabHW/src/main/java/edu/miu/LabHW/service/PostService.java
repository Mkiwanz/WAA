package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<Post> findPost();

    Post findPostById(int id);

    void deleteById(int id);

    void updateById(int id,Post post);
}
