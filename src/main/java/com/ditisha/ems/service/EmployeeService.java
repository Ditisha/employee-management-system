package com.ditisha.ems.service;

import com.ditisha.ems.exception.ResourceNotFoundException;
import com.ditisha.ems.model.Department;
import com.ditisha.ems.model.Employee;
import com.ditisha.ems.repository.DepartmentRepository;
import com.ditisha.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> getAll(String search) {
        if (search == null || search.isBlank()) {
            return employeeRepository.findAll();
        }
        return employeeRepository.findByNameContainingIgnoreCase(search);
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
    }

    public Employee create(Employee employee) {
        employee.setId(null);
        employee.setDepartment(resolveDepartment(employee.getDepartment()));
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee updated) {
        Employee existing = getById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setSalary(updated.getSalary());
        existing.setDepartment(resolveDepartment(updated.getDepartment()));
        return employeeRepository.save(existing);
    }

    public void delete(Long id) {
        employeeRepository.delete(getById(id));
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartment(Department department) {
        department.setId(null);
        return departmentRepository.save(department);
    }

    private Department resolveDepartment(Department department) {
        if (department == null || department.getId() == null) {
            return null;
        }
        return departmentRepository.findById(department.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + department.getId()));
    }
}
