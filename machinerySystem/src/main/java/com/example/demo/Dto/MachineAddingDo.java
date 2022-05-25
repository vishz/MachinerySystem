package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MachineAddingDo {
    private int code;
    private String name;
    private Long dailyRentalFee;
}
