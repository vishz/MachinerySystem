package service;

import Dto.*;

import java.util.List;

public interface CommonService {
    void addMachine(MachineAddingDo machineAddingDo);
    void updateMachine(MachineUpdateDto machineUpdateDto);
    void delete(Long id);
    List<MachineListDto> viewMachineList();
    long rent(MachineRentDto machineRentDto);
    List<ReportDto> getReport();


}
