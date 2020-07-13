package composition;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddBook { 

	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		c.configure();  // load hibernate.cfg.xml
		
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession();
		
		Book b = new Book();
		b.setTitle("Hibernate");
		b.setPrice(500);

		Transaction trans = s.beginTransaction();
		s.save(b);  
		trans.commit();
		s.close();   
		sf.close();
	}
}
