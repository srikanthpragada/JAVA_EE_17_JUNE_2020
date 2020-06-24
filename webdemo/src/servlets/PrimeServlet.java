package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  String input = request.getParameter("number");
		  int num = Integer.parseInt(input);
		  boolean prime = true; 
		  
		  for(int i = 2; i <= num/2 ; i ++)
			  if ( num % i == 0 ) {
				  prime = false;
				  break;
			  }

		  PrintWriter pw = response.getWriter();
		  if(prime)
			  pw.println("<h1>Prime Number</h1>");
		  else
			  pw.println("<h1>Not a Prime Number</h1>");
	}

}
