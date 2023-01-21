package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.repo.PostRepo;
import edu.miu.LabHW.repo.UserRepo;
import edu.miu.LabHW.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;

    @Autowired
    public postServiceImpl(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public Post findAllById(long id) {
        return postRepo.findAllById(id);
    }

    @Override
    public void deleteById(long id) {
        postRepo.deleteById(id);
    }

    @Override
    public void updateById(int id, Post post) {
        postRepo.save(post);
    }

    @Override
    public List<Post> findAllByTitleEquals(String title) {
        return postRepo.findAllByTitleEquals(title);
    }

    @Override
    public List<Post> findPostByUser_Id(long id) {
        return postRepo.findPostByUsers_Id(id);
    }

    @Override
    public Post findPostByUsers_IdAndId(long id, long post_id) {
        return postRepo.findPostByUsers_IdAndId(id, post_id);
    }

    @Override
    public void addUserPost(long user_id, Post post) {
        var user = userRepo.findAllById(user_id);
        if (user != null) {
            post.setUsers(user);
            postRepo.save(post);
        } else
            System.out.println("There is no user");
    }
}
