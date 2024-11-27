package com.crm.controller;

import com.crm.payload.EmployeeDto;
import com.crm.service.EmployeeService;
import jakarta.validation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employee")

public class EmployeeController {


    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(
        @Valid @RequestBody EmployeeDto dto,
        BindingResult result
    ) {
        if (result.hasErrors())
        {
            List<String> errors= result.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
        }


        EmployeeDto employeeDto = employeeService.addEmployee(dto);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(
        @RequestParam Long id
    ) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto
    ) {
        EmployeeDto employeeDto = employeeService.updateEmployee(id,dto);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    // http://localhost:8080/api/v1/employee?pageSize=5&pageNo=1&sortBy=emailId
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployee(
            @RequestParam(name="pageSize" ,required = false, defaultValue = "5") int pageSize,
            @RequestParam(name="pageNo" ,required = false, defaultValue = "0") int pageNo,
            @RequestParam(name="sortBy" ,required = false, defaultValue = "name") String sortBy,
            @RequestParam(name="sortDis" ,required = false, defaultValue = "dis") String sortDis
    ) {
    List<EmployeeDto> employees = employeeService.getEmployee(pageNo,pageSize,sortBy,sortDis);
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //   http://localhost:8080/api/v1/employee/employeeId/{empId}
    @GetMapping("/employeeId/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(
            @PathVariable Long empId  // replace empId with actual variable name in your entity class
    ) {
        EmployeeDto dto = employeeService.getEmployeeById(empId);
        return  new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
