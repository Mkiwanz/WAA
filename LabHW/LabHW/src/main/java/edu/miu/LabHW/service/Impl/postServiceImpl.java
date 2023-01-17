package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.repo.PostRepo;
import edu.miu.LabHW.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postServiceImpl implements PostService {

    private final
    PostRepo postRepo;

    public postServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> findPost() {
        return postRepo.findPost();
    }

    @Override
    public Post findPostById(int id) {
        return postRepo.findPostById(id);
    }

    @Override
    public void deleteById(int id) {
        postRepo.deleteById(id);

    }

    @Override
    public void updateById(int id, Post post) {
        postRepo.updateById(id, post);
    }
}
