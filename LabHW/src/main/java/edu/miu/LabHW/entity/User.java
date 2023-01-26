package edu.miu.LabHW.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String firstname;
    private String lastname;
    String email;
    String password;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Post> posts;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;

}
