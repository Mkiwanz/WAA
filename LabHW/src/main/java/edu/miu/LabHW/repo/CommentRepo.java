package edu.miu.LabHW.repo;

import edu.miu.LabHW.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {

    List<Comment> findAll();

    Comment findAllById(long id);

    List<Comment> findAllByPost_User_IdAndPost_Id(long user_id,long post_id);
}
