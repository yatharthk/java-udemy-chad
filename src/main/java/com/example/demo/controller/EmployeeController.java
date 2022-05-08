package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    List<Employee> employees;

    @PostConstruct
    private void loadData(){


        Employee employee = new Employee(1,"Leslie","Andrews","leslie@gmail.com");
        Employee employee2 = new Employee(2,"Ashley","Andrews","ashlie@gmail.com");
        Employee employee3 = new Employee(3,"Avni","Gupta","avni@gmail.com");
        employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee2);
        employees.add(employee3);
    }

    @GetMapping("/list")
    public String getAllEmployees(Model model) {
        Employee employee = new Employee(1,"Leslie","Andrews","leslie@gmail.com");
        Employee employee2 = new Employee(2,"Ashley","Andrews","ashlie@gmail.com");
        Employee employee3 = new Employee(3,"Avni","Gupta","avni@gmail.com");



        model.addAttribute("employees",employees);

        return "list-employees";

    }
}
