package edu.miu.LabHW.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long transactionId;
    LocalDate date;
    LocalTime time;
    String principle;
    String operation;

}
