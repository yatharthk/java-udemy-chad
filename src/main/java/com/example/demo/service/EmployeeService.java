package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee findById(int theId);

    void save(Employee e);

    void deleteEmployee(int theId);
}
