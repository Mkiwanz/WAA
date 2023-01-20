package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.entity.Comment;
import edu.miu.LabHW.repo.CommentRepo;
import edu.miu.LabHW.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;

    @Autowired
    commentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findAllById(long id) {
        return commentRepo.findAllById(id);
    }
}
