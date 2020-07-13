package core;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ListEmployees {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // load hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();

		List<Employee> employees = s.createQuery("from Employee").list();

		for (Employee e : employees) {
			System.out.printf("%-30s  - %d\n", e.getFullname(), e.getSalary());
		}
		s.close();
		sf.close();
	}
}
