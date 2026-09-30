package com.ditisha.ems;

import com.ditisha.ems.model.Department;
import com.ditisha.ems.repository.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    // Adds a few departments on first run so the app is usable immediately
    @Bean
    CommandLineRunner seedDepartments(DepartmentRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new Department("Engineering"));
                repo.save(new Department("Human Resources"));
                repo.save(new Department("Finance"));
            }
        };
    }
}
