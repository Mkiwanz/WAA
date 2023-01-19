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
}
