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
    private final userServiceImpl userService;
    private final postServiceImpl postService;

    @Autowired
    commentServiceImpl(CommentRepo commentRepo, userServiceImpl userService, postServiceImpl postService) {
        this.commentRepo = commentRepo;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepo.findAll();
    }

    @Override
    public Comment findAllById(long id) {
        return commentRepo.findAllById(id);
    }

    @Override
    public void saveComment(long user_id, long post_id, Comment comment) {
        var user = userService.findAllById(user_id);

        if (user != null) {
            var post = postService.findAllById(post_id);
            if (post != null) {
                comment.setPost(post);
                commentRepo.save(comment);
            } else System.out.println("there is no such Post");
        } else System.out.println("there is no such User");
    }

    @Override
    public List<Comment> findAllByPost_Users_IdAndPost_Id(long user_id, long post_id) {
        return commentRepo.findAllByPost_Users_IdAndPost_Id(user_id, post_id);
    }
}
