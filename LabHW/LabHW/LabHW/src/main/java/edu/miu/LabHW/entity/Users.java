package edu.miu.LabHW.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    long id;
    String name;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    List<Post> posts;

}
