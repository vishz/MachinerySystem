package com.example.demo.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    private Long rentId;
    private String nic;
    private String customerName;
    private String mobileNumber;
    private String machineName;
    private long dailyRentalFee;
    private int noOfDays;
    private Date rentedDate;
    private long total;

}
