package edu.miu.LabHW.controller;

import edu.miu.LabHW.entity.Comment;
import edu.miu.LabHW.entity.dto.CommentDTO;
import edu.miu.LabHW.repo.CommentRepo;
import edu.miu.LabHW.service.CommentService;
import edu.miu.LabHW.service.Impl.commentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final
    commentServiceImpl commentService;

    public CommentController(commentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentDTO> findAllComments() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDTO findAllCommentsById(@PathVariable long id) {
        return commentService.findAllById(id);
    }


}
