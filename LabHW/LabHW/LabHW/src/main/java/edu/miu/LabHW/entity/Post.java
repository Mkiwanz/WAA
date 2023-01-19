package edu.miu.LabHW.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    long id;
    String title;
    String content;
    String author;

}
