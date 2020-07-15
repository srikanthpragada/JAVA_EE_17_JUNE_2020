package jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListEmployees {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Employee> employees = entityManager.createQuery("from Employee").getResultList();

		for (Employee e : employees)
			System.out.printf("%-20s  %s\n",e.getName(),e.getJob().getTitle());

	}

}
