package com.example.emp.Repository;

import com.example.emp.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
