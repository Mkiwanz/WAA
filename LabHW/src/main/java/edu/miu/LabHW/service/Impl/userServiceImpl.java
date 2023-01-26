package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.entity.User;
import edu.miu.LabHW.entity.dto.UserDTO;
import edu.miu.LabHW.repo.UserRepo;
import edu.miu.LabHW.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class userServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public userServiceImpl(UserRepo userRepo, ModelMapper modelMapper) {
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOS = new ArrayList<>();
        userRepo.findAll().forEach(x -> userDTOS.add(modelMapper.map(x, UserDTO.class)));
        return userDTOS;
    }


    @Override
    public UserDTO findAllById(long id) {
        return modelMapper.map(userRepo.findAllById(id), UserDTO.class);
    }

    @Override
    public UserDTO addUser(User user) {
        return modelMapper.map(userRepo.save(user), UserDTO.class);
    }

    @Override
    public List<UserDTO> findUserWithPosts(int num) {
        List<UserDTO> userDTOS = new ArrayList<>();
        userRepo.findUserWithPosts(num).forEach(x -> userDTOS.add(modelMapper.map(x, UserDTO.class)));
        return userDTOS;
    }


}
