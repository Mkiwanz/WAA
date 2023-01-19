package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    Post findAllById(long id);

    void deleteById(long id);

    void updateById(int id,Post post);
}
