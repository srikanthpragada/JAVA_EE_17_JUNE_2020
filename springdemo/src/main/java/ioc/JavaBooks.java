package ioc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JavaBooks implements Books {

	@Override
	public List<String> getBooks() {
		ArrayList<String> books = new ArrayList<>();
		books.add("Java Comp. Ref");
		books.add("Thinking in Java");
		return books;
	}

	@Override
	public String getTopic() {
		return "Java";
	}

}
