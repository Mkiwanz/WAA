package edu.miu.LabHW.repo;

import edu.miu.LabHW.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    List<User> findAll();

    User findAllById(long id);


    @Query(value = "select u from User u where size(u.posts) >= :num")
    List<User> findUserWithPosts(int num);

    User findByEmail(String email);
}
