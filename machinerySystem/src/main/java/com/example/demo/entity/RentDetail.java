package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private int noOfDays;

    @CreationTimestamp
    private Date date;
    private Long total;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "machine_id")
    private Machine machine;

    public RentDetail(int quantity, int noOfDays, Long total, Customer customer, Machine machine) {
        this.quantity = quantity;
        this.noOfDays = noOfDays;
        this.total = total;
        this.customer = customer;
        this.machine = machine;
    }
}
