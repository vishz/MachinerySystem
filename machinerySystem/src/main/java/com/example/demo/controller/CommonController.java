package com.example.demo.controller;



import com.example.demo.Dto.*;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CommonService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value="api/v1/machinery")
@CrossOrigin
@RequiredArgsConstructor
public class CommonController {
    private final CommonService commonService;

    @PostMapping(value = "/machine", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> addMachine(@RequestBody MachineAddingDo machineAddingDo) {
        commonService.addMachine(machineAddingDo);
        return ResponseEntity.ok(new CommonResponse<>(true, "machine is successfully added"));
    }

    @PutMapping(value = "/machine", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<String>> updateMachine(@RequestBody MachineUpdateDto machineUpdateDto) {
        commonService.updateMachine(machineUpdateDto);
        return ResponseEntity.ok(new CommonResponse<>(true, "machine is successfully updated"));
    }

    @DeleteMapping(value = "/machine", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteMachine(@RequestBody JsonNode reqBody) {
        Long id = reqBody.get("id").asLong();
        commonService.delete(id);
        return ResponseEntity.ok(new CommonResponse<>(true, "Machine is Successfully Deleted"));
    }

    @GetMapping(value = "/machine", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<MachineListDto>>> viewMachineList() {
        List<MachineListDto> machineListDtos = commonService.viewMachineList();
        return ResponseEntity.ok(new CommonResponse<>(true, machineListDtos));
    }

    @PostMapping(value = "/rent", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<Long>> rentMachine(@RequestBody MachineRentDto machineRentDto) {
        long total = commonService.rent(machineRentDto);
        return ResponseEntity.ok(new CommonResponse<>(true,total ));
    }

    @GetMapping(value = "/report", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse<List<ReportDto>>> getReport() {
        List<ReportDto> reportDtoList = commonService.getReport();
        return ResponseEntity.ok(new CommonResponse<>(true, reportDtoList));
    }

}
