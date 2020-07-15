package jpa;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {
	private String id, title;
	private int minSal;
	private Set<Employee> employees;

	@OneToMany(mappedBy = "job")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Id
	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "minsal")
	public int getMinSal() {
		return minSal;
	}

	public void setMinSal(int minSal) {
		this.minSal = minSal;
	}
}
