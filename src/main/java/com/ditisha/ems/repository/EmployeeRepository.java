package com.ditisha.ems.repository;

import com.ditisha.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Derived query: search by name, ignoring case
    List<Employee> findByNameContainingIgnoreCase(String name);
}
