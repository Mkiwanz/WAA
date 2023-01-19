package edu.miu.LabHW.repo;

import edu.miu.LabHW.entity.Post;
import edu.miu.LabHW.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<Users, Long> {

    List<Users> findAll();

    Users findAllById(long id);

}
