package com.vagtplan.api.controllers;

import com.vagtplan.api.Model.EmployeeDTO;
import com.vagtplan.api.entities.Employee;
import com.vagtplan.api.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/api/employees")
    public List<EmployeeDTO> getAllEmployees() {
        System.out.println("GETTING EMPLOYEES");
        return employeeService.findAll();
    }

    @GetMapping("/api/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Optional<EmployeeDTO> employee = employeeService.getById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/employees")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.saveEmployee(employeeDTO);
    }

    @DeleteMapping("/api/employees/delete/{id}")
    public String deleteEmployeeWithId(@PathVariable Long id) {
        employeeService.deleleteEmployeeWithId(id);
        return "deleted employee with id: " + id;
    }



}
