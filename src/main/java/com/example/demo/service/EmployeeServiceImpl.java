package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    @Autowired
//    @Qualifier("employeeJpaDaoImpl")
//    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee e = null;
        if(result.isPresent()) {
            return result.get();
        }
        throw new RuntimeException("Could not find the employee with id:"+theId);
    }

    @Override
    public void save(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    
    @Modifying
    public void deleteEmployee(int theId) {
        employeeRepository.deleteById(theId);
    }
}
