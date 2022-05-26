package com.example.demo.service.impl;

import com.example.demo.Dto.*;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Machine;
import com.example.demo.entity.RentDetail;
import com.example.demo.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.MachineRepository;
import com.example.demo.repository.RentDetailRepository;
import com.example.demo.exception.CustomServiceException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CommonServiceImpl implements CommonService {
    private final MachineRepository machineRepository;
    private final RentDetailRepository rentDetailRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void addMachine(MachineAddingDo machineAddingDo) {
        Machine machine = new Machine(machineAddingDo.getCode(),machineAddingDo.getName(),machineAddingDo.getDailyRentalFee());
        machineRepository.save(machine);
    }

    @Override
    public void updateMachine(MachineUpdateDto machineUpdateDto) {

        Machine machine = machineRepository.findById(machineUpdateDto.getId()).orElseThrow(() -> new CustomServiceException("Machine not found!"));
        machine.setCode(machineUpdateDto.getCode());
        machine.setName(machineUpdateDto.getName());
        machine.setDailyRentalFee(machineUpdateDto.getDailyRentalFee());
        machineRepository.save(machine);
    }

    @Override
    public void delete(Long id) {
        Machine machine = machineRepository.findById(id).orElseThrow(() -> new CustomServiceException("Machine not found!"));
        machineRepository.delete(machine);
    }

    @Override
    public List<MachineListDto> viewMachineList() {
        List<Machine> machineList= machineRepository.findAll();
        List<MachineListDto> machineListDtoList = new ArrayList<>();
        for (Machine machine : machineList) {
            machineListDtoList.add(new MachineListDto(machine.getId(),machine.getCode(),machine.getName(),machine.getDailyRentalFee()));
        }
        return machineListDtoList;
    }

    @Override
    public long rent(MachineRentDto machineRentDto) {
        Machine machine = machineRepository.findById(machineRentDto.getMachineId()).orElseThrow(() -> new CustomServiceException("Machine not found!"));
        Customer customer = customerRepository.getCustomerByNic(machineRentDto.getNic()).orElseThrow(() -> new CustomServiceException("Customer not found!"));
        int quantity = machineRentDto.getQuantity();
        int noOfDays = machineRentDto.getNoOfDays();
        long fee = machine.getDailyRentalFee();
        System.out.println(quantity);
        System.out.println(noOfDays);
        System.out.println(fee);
        long total=((long)quantity) * ((long)noOfDays) * fee;
        System.out.println(total);
        RentDetail rentDetail = new RentDetail(machineRentDto.getQuantity(),machineRentDto.getNoOfDays(),total,customer,machine);
        System.out.println(rentDetail);
        rentDetailRepository.save(rentDetail);
        //rentDetailRepository.save(rentDetail);
        return total;
    }

    @Override
    public List<ReportDto> getReport() {
        List<RentDetail> rentDetailList= rentDetailRepository.findAll();
        List<ReportDto> reportDtoList = new ArrayList<>();
        for (RentDetail rentDetail : rentDetailList) {
            reportDtoList.add(new ReportDto(rentDetail.getId(),rentDetail.getCustomer().getNic(),rentDetail.getCustomer().getName(),
                    rentDetail.getCustomer().getMobileNumber(),rentDetail.getMachine().getName(),rentDetail.getMachine().getDailyRentalFee(),
                    rentDetail.getNoOfDays(),rentDetail.getDate(),rentDetail.getTotal()
                    ));
        }
        return reportDtoList;
    }


}
