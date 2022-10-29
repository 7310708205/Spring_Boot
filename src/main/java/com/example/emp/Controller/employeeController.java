package com.example.emp.Controller;

import com.example.emp.Models.Employee;
import com.example.emp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class employeeController {
    @Autowired
    private EmployeeService employeeService;

    public employeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Employee> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id")int id,@RequestBody Employee employee)
    {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")int id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }
}