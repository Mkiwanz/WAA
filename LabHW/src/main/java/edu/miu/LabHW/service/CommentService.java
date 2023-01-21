package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.Comment;
import edu.miu.LabHW.repo.CommentRepo;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findAllById(long id);

    void saveComment(long user_id,long post_id,Comment comment);

    List<Comment> findAllByPost_Users_IdAndPost_Id(long user_id,long post_id);

}
