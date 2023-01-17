package edu.miu.LabHW.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostV2 {
    long id;
    String title;
    String content;
    String author;
}
