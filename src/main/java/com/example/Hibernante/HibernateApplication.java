package com.example.Hibernante;

import java.util.Iterator;
import java.util.List;
import javax.persistence.Entity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateApplication {
	 private static  SessionFactory factory;

	    public static void main(String[] args) {
	    	factory = HibernateUtil.getSessionFactory();
	        HibernateApplication manageEmployee = new HibernateApplication();
	
//	        Integer empID1 = manageEmployee.addEmployee("hoa", "Bishop", 4000,1);
//	        Integer empID2 = manageEmployee.addEmployee("my", "Ali", 5000,1);
//	        Integer empID3 = manageEmployee.addEmployee("John", "Vector", 10000,2);
	 
//	        Integer depID1 = manageEmployee.addDepartment("IT");
	        
	        
	        System.out.println("List down all the employees:");
	        manageEmployee.listEmployees();
//	      
	        manageEmployee.updateEmployee(2,"hung","thinh",500,2);
	       
//	        
//	 
//	        manageEmployee.deleteEmployee(4);
//	 
//	        
	        System.out.println("List down new list of the employees:");
	        manageEmployee.listEmployees();
	    }
	    public Integer addEmployee(String firstname, String lastname, int salary,int depId) {
	    	
	        Session session = factory.openSession();
	        Transaction tx = null;
	        Integer id = null;
	        try {
	            tx = session.beginTransaction();
	            Employee employee = new Employee(firstname, lastname, salary, depId);
	            id = (Integer) session.save(employee);
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null)
	                tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	     return id;
	    }
	    
	    public Integer addDepartment( String depName) {
	        Session session = factory.openSession();
	        Transaction tx = null;
	        Integer id = null;
	        try {
	            tx = session.beginTransaction();
	            Department department = new Department(depName);
	            id = (Integer) session.save(department);
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null)
	                tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return id  ;
	    }
	 
	    public void listEmployees() {
	        Session session = factory.openSession();
	        try {
	            List employees = session.createQuery("FROM Employee").list();
	            for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
	                Employee employee = (Employee) iterator.next();
	                System.out.println("ID: " + employee.getId());
	                System.out.print("First Name: " + employee.getFirstName());
	                System.out.print("  Last Name: " + employee.getLastName());
	                System.out.println("  Salary: " + employee.getSalary());
	                System.out.println("  department: " + employee.getDepId());
	            }
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	    public void listDepartment() {
	        Session session = factory.openSession();
	        try {
	            List department = session.createQuery("FROM Department").list();
	            for (Iterator iterator = department.iterator(); iterator.hasNext();) {
	            	Department department1 = (Department) iterator.next();
	                System.out.print("ID: " + department1.getDepId());
	                System.out.println("  Name Dep: " + department1.getDepName());
	            }
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	  //// Update employee and department
	    public void updateEmployee(Integer id,String firstName, String lastName, Integer salary,Integer depId ) {
	        Session session = factory.openSession();
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            Employee employee = (Employee) session.get(Employee.class, id);
	            employee.setSalary(salary);
	            employee.setFirstName(firstName);;
	            employee.setLastName(lastName);;
	            employee.setDepId(depId);
	            session.update(employee);
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null)
	                tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	    public void updateDepartment(Integer id, String depname ) {
	        Session session = factory.openSession();
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            Department department = (Department) session.get(Department.class, id);
	            department.setDepName(depname);
	            session.update(department);
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null)
	                tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	 
	    //  DELETE an employee ,department
	    public void deleteEmployee(Integer id) {
	        Session session = factory.openSession();
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            Employee employee = (Employee) session.get(Employee.class, id);
	            session.delete(employee);
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null)
	                tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	    public void deleteDepartment(Integer id) {
	        Session session = factory.openSession();
	        Transaction tx = null;
	        try {
	            tx = session.beginTransaction();
	            Department department = (Department) session.get(Department.class, id);
	            session.delete(department);
	            tx.commit();
	        } catch (HibernateException e) {
	            if (tx != null)
	                tx.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }

}
