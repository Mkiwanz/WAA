package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();

    Comment findAllById(long id);
}
