package core;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetJob { 

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure();  // load hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
        
		Job job = s.load(Job.class,"HBPRO"); // Class and Primary key
		System.out.println(job.getClass());
		System.out.println(job.getTitle());
		
		s.close();
		sf.close();
	}
}
