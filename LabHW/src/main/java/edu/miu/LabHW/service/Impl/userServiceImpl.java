package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.entity.Annotaions.ExecutionTime;
import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.Users;
import edu.miu.LabHW.entity.dto.UsersDTO;
import edu.miu.LabHW.repo.UserRepo;
import edu.miu.LabHW.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<UsersDTO> findAll() {
        List<UsersDTO> usersDTOS = new ArrayList<>();
        userRepo.findAll().forEach(x -> usersDTOS.add(modelMapper.map(x, UsersDTO.class)));
        return usersDTOS;
    }


    @Override
    public UsersDTO findAllById(long id) {
        return modelMapper.map(userRepo.findAllById(id), UsersDTO.class);
    }

    @Override
    public UsersDTO addUser(Users users) {
        return modelMapper.map(userRepo.save(users), UsersDTO.class);
    }

    @Override
    public List<UsersDTO> findUsersWithPosts(int num) {
        List<UsersDTO> usersDTOS = new ArrayList<>();
        userRepo.findUsersWithPosts(num).forEach(x -> usersDTOS.add(modelMapper.map(x, UsersDTO.class)));
        return usersDTOS;
    }


}
