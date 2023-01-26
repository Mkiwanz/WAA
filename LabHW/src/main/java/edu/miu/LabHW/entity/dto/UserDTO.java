package edu.miu.LabHW.entity.dto;

import lombok.Data;


@Data
public class UserDTO {
    
    long id;
    String firstname;
    String lastname;
    String email;
}