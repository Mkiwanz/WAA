package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.Users;
import edu.miu.LabHW.repo.UserRepo;
import edu.miu.LabHW.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class userServiceImpl implements UserService {

    final
    UserRepo userRepo;

    public userServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<Users> findAll() {
        var r = userRepo.findAll();
        r.stream()
                .forEach(u -> u.getPosts());
        return r;
    }

    @Override
    public List<Post> findAllPostsByUserId(long id) {
        return findAll().stream().filter( x-> x.getId() == id).flatMap( e-> e.getPosts().stream()).toList();
    }

    @Override
    public Users findAllById(long id) {
        return userRepo.findAllById(id);
    }

    @Override
    public Users addUser(Users users) {
        return userRepo.save(users);
    }


}