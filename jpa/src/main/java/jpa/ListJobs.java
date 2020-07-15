package jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListJobs {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		List<Job> jobs = entityManager.createQuery("from Job").getResultList();

		for (Job job : jobs)
			System.out.println(job.getTitle());

	}

}
