package com.example.Hibernante;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

import lombok.Data;
@Data
@Entity
@Table(name = "departments")
public class Department implements java.io.Serializable {
    private Integer depId;
    private String depName;
 
    public Department() {
    }
 
    public Department( String depName) {
        this.setDepId(depId);
        this.setDepName(depName);
    }
 
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "depId", unique = true, nullable = false)
public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	 @Column(name = "depName", length = 20)
	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}


	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="DepId")
	private Set<Employee> employeess;
}
