package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeJpaDaoImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        Employee emp = entityManager.find(Employee.class,theId);
        return emp;
    }

    @Override
    public void save(Employee e) {
        entityManager.merge(e);
    }

    @Override
    public void deleteById(int theId) {
        Query q = entityManager.createQuery("delete from Employee where id=:employeeId");
        q.setParameter("employeeId",theId);
        q.executeUpdate();
    }
}
