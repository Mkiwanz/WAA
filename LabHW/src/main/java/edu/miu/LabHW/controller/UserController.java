package edu.miu.LabHW.controller;

import edu.miu.LabHW.entity.Comment;
import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.Users;
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
    public List<Users> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Users findAllById(@PathVariable long id) {
        return userService.findAllById(id);
    }

    @PostMapping
    public Users AddUser(@RequestBody Users user) {
        return userService.addUser(user);
    }

    @GetMapping("/{id}/posts")
    public List<Post> findAllPostsByUserId(@PathVariable long id) {
        return postService.findPostByUser_Id(id);
    }

    @PostMapping("/{user_id}/posts")
    public void addUserPost(@PathVariable long user_id, @RequestBody Post post) {
        postService.addUserPost(user_id, post);
    }

    @PostMapping("/{user_id}/posts/{post_id}/comments")
    public void addComment(@PathVariable(name = "user_id") long user_id, @PathVariable(name = "post_id") long post_id, @RequestBody Comment comment) {
        commentService.saveComment(user_id, post_id, comment);
    }

    @GetMapping("/{id}/posts/{post_id}")
    public Post findAllPostsByUserAndPost(@PathVariable(name = "id") long id, @PathVariable(name = "post_id") long post_id) {
        return postService.findPostByUsers_IdAndId(id, post_id);
    }

    @GetMapping("/{user_id}/posts/{post_id}/comments")
    public List<Comment> findAllPostsComments(@PathVariable(name = "user_id") long user_id, @PathVariable(name = "post_id") long post_id) {
        return commentService.findAllByPost_Users_IdAndPost_Id(user_id, post_id);
    }

    @GetMapping("filter/posts/{num}")
    public List<Users> findUsersWithPosts(@PathVariable(name = "num") int num) {
        return userService.findUsersWithPosts(num);
    }


}
