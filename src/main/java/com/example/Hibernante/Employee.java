package com.example.Hibernante;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employeess")
public class Employee implements java.io.Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private int salary;
    private int depId;
   
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    @Column(name = "first_name", length = 20)
    public String getFirstName() {
        return this.firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    @Column(name = "last_name", length = 20)
    public String getLastName() {
        return this.lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    @Column(name = "salary")
    public Integer getSalary() {
        return this.salary;
    }
 
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
    @Column(name = "depId")
    public int getDepId() {
		return depId;
	}
	 
	public void setDepId(int depId) {
		this.depId = depId;
	}
   
	  public Department getDepartment() {
	      return departments;
	   }

	   public void setDepartment(Department department) {
	      this.departments = department;
	   }
    public Employee() {
    }
    
	    public Employee(String firstName, String lastName, Integer salary,Integer depId) {
	    	this.id=id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.salary = salary;
	        this.depId= depId;
	    }
	  

		@ManyToOne
		@JoinColumn(name="depId" )
		private Department departments;

		}