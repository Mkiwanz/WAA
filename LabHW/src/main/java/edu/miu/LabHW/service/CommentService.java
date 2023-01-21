package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.Comment;
import edu.miu.LabHW.entity.dto.CommentDTO;
import edu.miu.LabHW.repo.CommentRepo;

import java.util.List;

public interface CommentService {
    List<CommentDTO> findAll();

    CommentDTO findAllById(long id);

    void saveComment(long user_id,long post_id,Comment comment);

    List<CommentDTO> findAllByPost_Users_IdAndPost_Id(long user_id,long post_id);

}
