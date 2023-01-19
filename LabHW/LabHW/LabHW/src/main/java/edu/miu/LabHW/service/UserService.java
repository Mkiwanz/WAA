package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    List<Post> findAllPostsByUserId(long id);


    Users findAllById(long id);

    Users addUser(Users users);

}