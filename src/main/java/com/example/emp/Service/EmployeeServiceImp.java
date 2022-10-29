package com.example.emp.Service;

import com.example.emp.Models.Employee;
import com.example.emp.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{
    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo=employeeRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }
    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepo.findById(id).orElseThrow();
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow();
        existingEmployee.setFname(employee.getFname());
        existingEmployee.setLname(employee.getLname());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setEmpid(employee.getEmpid());
        employeeRepo.save(existingEmployee);
        return existingEmployee;
    }
    public void deleteEmployee(int id) {
        employeeRepo.findById(id).orElseThrow();
        employeeRepo.deleteById(id);
    }
}
