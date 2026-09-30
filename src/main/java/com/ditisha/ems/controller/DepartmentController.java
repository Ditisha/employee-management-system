package com.ditisha.ems.controller;

import com.ditisha.ems.model.Department;
import com.ditisha.ems.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final EmployeeService service;

    public DepartmentController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Department> getAll() {
        return service.getDepartments();
    }

    @PostMapping
    public ResponseEntity<Department> create(@Valid @RequestBody Department department) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createDepartment(department));
    }
}
