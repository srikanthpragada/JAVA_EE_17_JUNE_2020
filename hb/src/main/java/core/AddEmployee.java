package core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddEmployee { 

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure();  // load hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Employee e = new Employee();
		e.setFullname("Jack Willson");
		e.setJob("jpro");
		e.setSalary(600000);

		System.out.println("Inserting with id : " + e.getId());
		
		Transaction trans = s.beginTransaction();
		s.save(e);  // Insert into JOBS table   -  Transient to Persistent
		System.out.println("Inserted! with id : " + e.getId());
		trans.commit();
		System.out.println("Committed!");
		s.close();    // Detached 
		sf.close();
	}
}
