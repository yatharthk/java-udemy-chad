package com.yk.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yk.jdbc.entity.Employee;

public class CrudEmployee {

	public static void main(String[] args) {
		//create session factory method and get the session
		
		SessionFactory factory= new Configuration()
				.configure("resources/hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		
		
Session session= factory.getCurrentSession();

try {
//add some Employees
Employee e1= new Employee("y","k","CompanyA");
Employee e2= new Employee("s","k","CompanyB");
Employee e3= new Employee("n","k","CompanyC");
Employee e4= new Employee("a","k","CompanyA");


Employee[] eList= {e1,e2,e3,e4};


System.out.println("Saving the objects");
session=factory.getCurrentSession();
session.beginTransaction();
for (int i=0;i<eList.length;i++) {
	System.out.println("Saving "+eList[i]);
	session.save(eList[i]);
	
//	
}
	session.getTransaction().commit();

//commit the changes to db //save operation
System.out.println("Saved");


//get the current session
session= factory.getCurrentSession();
session.beginTransaction();

//reading the saved object using id
System.out.println("Reading the first Employee saved to the db");
System.out.println(session.get(Employee.class, e1.getId()));

//get all the saved employees
System.out.println("displaying the records working in company A");
List<Employee> employeeList = session.createQuery("from Employee where company='CompanyA'").getResultList();

//reading the database results where company name is CompanyA
employeeList.forEach(System.out::println);

//delete one employee using id
System.out.println("Deleting the employee with id "+e4.getId());
	session.createQuery("delete Employee where id="+e4.getId()).executeUpdate();
	
	
}
finally{
	session.close();
	factory.close();
}

}
	
	


	
}
