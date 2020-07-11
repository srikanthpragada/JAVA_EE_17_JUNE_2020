package core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UpdateJob {

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure(); // load hibernate.cfg.xml

		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
	
		
		Job job = s.get(Job.class, "HBPRO");  // Class, Primary key

		if (job == null)
			System.out.println("Sorry! Job id not found!");
		else {
			Transaction trans = s.beginTransaction();
			job.setTitle("Hibernate 5 Programmer");
			s.save(job); // Update JOBS table
			trans.commit();
			System.out.println("Updated!");
		}

		s.close();
		sf.close();
	}
}
