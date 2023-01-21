package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.dto.PostDTO;
import edu.miu.LabHW.repo.PostRepo;
import edu.miu.LabHW.repo.UserRepo;
import edu.miu.LabHW.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class postServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public postServiceImpl(PostRepo postRepo, UserRepo userRepo, ModelMapper modelMapper) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<PostDTO> findAll() {
        List<PostDTO> postDTOS = new ArrayList<>();
        postRepo.findAll().forEach(x -> postDTOS.add(modelMapper.map(x, PostDTO.class)));
        return postDTOS;
    }

    @Override
    public PostDTO findAllById(long id) {
        return modelMapper.map(postRepo.findAllById(id), PostDTO.class);
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
    public List<PostDTO> findAllByTitleEquals(String title) {
        List<PostDTO> postDTOS = new ArrayList<>();
        postRepo.findAllByTitleEquals(title).forEach(x -> postDTOS.add(modelMapper.map(x, PostDTO.class)));
        return postDTOS;
    }

    @Override
    public List<PostDTO> findPostByUser_Id(long id) {
        List<PostDTO> postDTOS = new ArrayList<>();
        postRepo.findPostByUsers_Id(id).forEach(x -> postDTOS.add(modelMapper.map(x, PostDTO.class)));
        return postDTOS;
    }

    @Override
    public PostDTO findPostByUsers_IdAndId(long id, long post_id) {
        return modelMapper.map(postRepo.findPostByUsers_IdAndId(id, post_id), PostDTO.class);
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
