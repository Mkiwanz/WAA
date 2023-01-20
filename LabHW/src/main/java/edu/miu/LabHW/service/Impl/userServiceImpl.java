package edu.miu.LabHW.service.Impl;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.Users;
import edu.miu.LabHW.repo.UserRepo;
import edu.miu.LabHW.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class userServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Autowired
    public userServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<Users> findAll() {
       /* var r = userRepo.findAll();
        r.stream()
                .forEach(u -> u.getPosts());
        System.out.println(r);
        return r;*/

        return userRepo.findAll();
    }

    @Override
    public List<Post> findAllPostsByUserId(long id) {
        return findAll().stream().filter(x -> x.getId() == id).flatMap(e -> e.getPosts().stream()).toList();
    }

    @Override
    public Users findAllById(long id) {
        return userRepo.findAllById(id);
    }

    @Override
    public Users addUser(Users users) {
        return userRepo.save(users);
    }

    @Override
    public List<Users> findUsersWithPosts(int num) {
        return userRepo.findUsersWithPosts(num);
    }


}
