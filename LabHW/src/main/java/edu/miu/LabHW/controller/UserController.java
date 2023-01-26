package edu.miu.LabHW.controller;

import edu.miu.LabHW.entity.Annotaions.ExecutionTime;
import edu.miu.LabHW.entity.Comment;
import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.User;
import edu.miu.LabHW.entity.dto.CommentDTO;
import edu.miu.LabHW.entity.dto.PostDTO;
import edu.miu.LabHW.entity.dto.UserDTO;
import edu.miu.LabHW.service.Impl.commentServiceImpl;
import edu.miu.LabHW.service.Impl.postServiceImpl;
import edu.miu.LabHW.service.Impl.userServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final userServiceImpl userService;
    private final postServiceImpl postService;
    private final commentServiceImpl commentService;

    UserController(userServiceImpl userService, postServiceImpl postService, commentServiceImpl commentService) {
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public UserDTO findAllById(@PathVariable long id) {
        return userService.findAllById(id);
    }

    @PostMapping
    public UserDTO AddUser(@RequestBody User user) {
        return userService.addUser(user);
    }
/*
    @GetMapping("/{id}/posts")
    public List<PostDTO> findAllPostsByUserId(@PathVariable long id) {
        return postService.findPostByUser_Id(id);
    }*/

    @PostMapping("/{user_id}/posts")
    public void addUserPost(@PathVariable long user_id, @RequestBody Post post) {
        postService.addUserPost(user_id, post);
    }

    @PostMapping("/{user_id}/posts/{post_id}/comments")
    public void saveComment(@PathVariable(name = "user_id") long user_id, @PathVariable(name = "post_id") long post_id, @RequestBody Comment comment) {
        commentService.saveComment(user_id, post_id, comment);
    }

    @GetMapping("/{id}/posts/{post_id}")
    public PostDTO findAllPostsByUserAndPost(@PathVariable(name = "id") long id, @PathVariable(name = "post_id") long post_id) {
        return postService.findPostByUser_IdAndId(id, post_id);
    }

    @GetMapping("/{user_id}/posts/{post_id}/comments")
    public List<CommentDTO> findAllPostsComments(@PathVariable(name = "user_id") long user_id, @PathVariable(name = "post_id") long post_id) {
        return commentService.findAllByPost_User_IdAndPost_Id(user_id, post_id);
    }

    @GetMapping("filter/posts/{num}")
    public List<UserDTO> findUserWithPosts(@PathVariable(name = "num") int num) {
        return userService.findUserWithPosts(num);
    }

    @GetMapping("/{user_id}/posts")
    public List<PostDTO> findPostByFilter(@PathVariable(name = "user_id") long user_id, @RequestParam(value = "author", required = false) String author, @RequestParam(value = "title", required = false) String title) {
        return author != null || title != null ? postService.findPostByUser_IdAndAuthorOrTitle(user_id, author, title) : postService.findPostByUser_Id(user_id);
    }



}
