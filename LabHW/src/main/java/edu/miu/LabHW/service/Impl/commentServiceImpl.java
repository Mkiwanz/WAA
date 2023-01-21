package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.entity.Comment;
import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.dto.CommentDTO;
import edu.miu.LabHW.entity.dto.PostDTO;
import edu.miu.LabHW.repo.CommentRepo;
import edu.miu.LabHW.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class commentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    private final userServiceImpl userService;
    private final postServiceImpl postService;
    private final ModelMapper modelMapper;

    @Autowired
    commentServiceImpl(CommentRepo commentRepo, userServiceImpl userService, postServiceImpl postService, ModelMapper modelMapper) {
        this.commentRepo = commentRepo;
        this.userService = userService;
        this.postService = postService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CommentDTO> findAll() {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        commentRepo.findAll().forEach(x -> commentDTOS.add(modelMapper.map(x, CommentDTO.class)));
        return commentDTOS;
    }

    @Override
    public CommentDTO findAllById(long id) {
        return modelMapper.map(commentRepo.findAllById(id), CommentDTO.class);
    }

    @Override
    public void saveComment(long user_id, long post_id, Comment comment) {
        var user = userService.findAllById(user_id);

        if (user != null) {
            var post = postService.findAllById(post_id);
            if (post != null) {
                comment.setPost(modelMapper.map(post, Post.class));
                commentRepo.save(comment);
            } else System.out.println("there is no such Post");
        } else System.out.println("there is no such User");
    }

    @Override
    public List<CommentDTO> findAllByPost_Users_IdAndPost_Id(long user_id, long post_id) {
        List<CommentDTO> commentDTOS = new ArrayList<>();
        commentRepo.findAllByPost_Users_IdAndPost_Id(user_id, post_id).forEach(x -> commentDTOS.add(modelMapper.map(x, CommentDTO.class)));
        return commentDTOS;
    }
}
