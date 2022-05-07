package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class Controller {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/home")
    public String getHome(){
        return "Home";
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") int theId){
        Employee emp= employeeService.findById(theId);
        if(emp == null) throw new RuntimeException("Employee Id not found : "+theId);
        return emp;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee e){
        e.setId(0);
        employeeService.save(e);
        return  e;
}

@PutMapping("/employees")
public Employee updateEmployee(@RequestBody Employee e){
        employeeService.save(e);
        return  e;
}

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable("id") int theId){
        Employee emp = employeeService.findById(theId);
        if(emp==null) throw new RuntimeException("Employee Not found with Id:"+theId);
        employeeService.deleteEmployee(theId);
        return "Deleted employee with id:"+theId;
    }

}
