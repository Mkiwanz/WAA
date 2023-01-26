package edu.miu.LabHW.service;

import edu.miu.LabHW.entity.User;
import edu.miu.LabHW.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();


    UserDTO findAllById(long id);

    UserDTO addUser(User user);

    List<UserDTO> findUserWithPosts(int num);




}
