package jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	private int id;
	private String name;
	private int salary;

	
	private Job job;
	
	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="fullname")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@ManyToOne
	@JoinColumn(name = "job")
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
}
