package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<PostDTO> findAll();

    PostDTO findAllById(long id);

    void deleteById(long id);

    void updateById(int id, Post post);

    List<PostDTO> findAllByTitleEquals(String title);

    List<PostDTO> findPostByUser_Id(long id);


    PostDTO findPostByUsers_IdAndId(long id, long post_id);

    void addUserPost(long user_id, Post post);

    List<PostDTO> findPostByUsers_IdAndAuthorOrTitle(long id, String author, String title);

    List<PostDTO> findPostsByCriteria(Post post);


}
