package edu.miu.LabHW.repo;

import edu.miu.LabHW.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    List<Post> findAll();

    Post findAllById(long id);

}
