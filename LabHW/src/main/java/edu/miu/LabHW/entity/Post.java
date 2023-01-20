package edu.miu.LabHW.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Post {
    @Id
    long id;
    String title;
    String content;
    String author;

    @OneToMany(mappedBy = "post",fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    List<Comment> comments;

}
