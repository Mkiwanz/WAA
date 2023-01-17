package edu.miu.LabHW.repo;

import edu.miu.LabHW.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo {

    List<Post> findPost();

    Post findPostById(int id);

    void deleteById(int id);

    void updateById(int id,Post post);
}
