package edu.miu.LabHW.entity;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comment {

    @Id
    long id;
    String name;

    @ManyToOne(cascade = CascadeType.REMOVE)
    Post post;

}
