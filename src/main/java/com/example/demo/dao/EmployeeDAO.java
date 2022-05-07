package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee e);

    void deleteById(int theId);
}
