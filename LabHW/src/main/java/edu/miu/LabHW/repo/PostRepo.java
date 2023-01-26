package edu.miu.LabHW.repo;

import edu.miu.LabHW.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    List<Post> findAll();

    Post findAllById(long id);

    List<Post> findAllByTitleEquals(String title);

    List<Post> findPostByUser_Id(long id);

    Post findPostByUser_IdAndId(long id, long post_id);

    List<Post> findPostByUser_IdAndAuthorOrTitle(long id, String author, String title);

}
