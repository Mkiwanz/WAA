package edu.miu.LabHW.controller;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.Users;
import edu.miu.LabHW.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
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
        return userService.findAllPostsByUserId(id);
    }

}
