package edu.miu.LabHW.controller;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.dto.PostDTO;
import edu.miu.LabHW.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @GetMapping
//    List<PostDTO> findAllPosts() {
//        return postService.findAll();
//    }

    @GetMapping("/{id}")
    PostDTO findAllPostsById(@PathVariable int id) {
        return postService.findAllById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        postService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable int id, @RequestBody Post p) {
        postService.updateById(id, p);
    }

    @GetMapping("/filter/title/{title}")
    List<PostDTO> findAllByTitleEquals(@PathVariable(name = "title") String title) {
        return postService.findAllByTitleEquals(title);
    }

    @GetMapping
    List<PostDTO> findAllByTitleEquals(@RequestBody(required = false) Post post) {
        return post == null ? postService.findAll() : postService.findPostsByCriteria(post);
    }
}
