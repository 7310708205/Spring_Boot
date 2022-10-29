package com.example.emp.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="EmployeeDetails")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String fname;
    @Column(nullable = false)
    private String lname;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private int salary;
    @Column(nullable = false)
    private int empid;
}
