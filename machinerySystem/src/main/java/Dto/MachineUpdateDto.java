package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MachineUpdateDto {
    private Long id;
    private int code;
    private String name;
    private Long dailyRentalFee;
}
