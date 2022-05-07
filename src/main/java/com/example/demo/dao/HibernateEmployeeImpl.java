package com.example.demo.dao;

import com.example.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class HibernateEmployeeImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;
    @Override

    public List<Employee> findAll() {
        Session session = entityManager.unwrap(Session.class) ;
        Query<Employee> q = session.createQuery("from Employee",Employee.class);
        return  q.getResultList();
    }

    @Override
    public Employee findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee e = currentSession.get(Employee.class,theId);
        return  e;
    }

    @Override
    public void save(Employee theEmployee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("delete from Employee where id=?1");
        q.setParameter(1,theId);
        q.executeUpdate();

    }
}
