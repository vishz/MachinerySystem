package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int code;
    private String name;
    private Long dailyRentalFee;

    public Machine(int code, String name, Long dailyRentalFee) {
        this.code = code;
        this.name = name;
        this.dailyRentalFee = dailyRentalFee;
    }
}
