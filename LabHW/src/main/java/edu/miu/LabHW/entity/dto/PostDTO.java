package edu.miu.LabHW.entity.dto;

import lombok.Data;

@Data
public class PostDTO {
    long id;
    String title;
    String content;
    String author;

}
