package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.Users;
import edu.miu.LabHW.entity.dto.UsersDTO;

import java.util.List;

public interface UserService {

    List<UsersDTO> findAll();


    UsersDTO findAllById(long id);

    UsersDTO addUser(Users users);

    List<UsersDTO> findUsersWithPosts(int num);




}
