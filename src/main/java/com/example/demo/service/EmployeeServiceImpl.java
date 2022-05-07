package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    @Modifying
    public void save(Employee e) {
        employeeDAO.save(e);
    }

    @Override
    @Transactional
    @Modifying
    public void deleteEmployee(int theId) {
        employeeDAO.deleteById(theId);
    }
}
