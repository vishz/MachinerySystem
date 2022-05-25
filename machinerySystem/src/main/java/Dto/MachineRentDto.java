package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MachineRentDto {
    private Long machineId;
    private String nic;
    private int quantity;
    private int noOfDays;

}
