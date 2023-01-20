package edu.miu.LabHW.repo;

import edu.miu.LabHW.entity.Users;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends CrudRepository<Users, Long> {

    List<Users> findAll();

    Users findAllById(long id);


    @Query(value ="select u from Users u where u.posts.size >= :num")
    List<Users> findUsersWithPosts(int num);
}
