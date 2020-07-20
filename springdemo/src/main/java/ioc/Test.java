package ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test implements CommandLineRunner{
	
	@Autowired 
    Books books;
    
	public static void main(String[] args) {
	     SpringApplication.run( Test.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 System.out.println("Topic : " + books.getTopic());
		 for(String s : books.getBooks())
			 System.out.println(s);
	}

}
