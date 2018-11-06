package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Engine;

/**
 * Servlet implementation class Prime
 */
@WebServlet("/Prime.do")
public class Prime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Engine engine = Engine.getInstance();
		
		String calc = request.getParameter("calc");
		
		if (calc != null) {
			String previous = request.getParameter("previous");
			String min = (previous != null)? previous : request.getParameter("min");
			String max = request.getParameter("max");
			
			

			try
			{
				request.setAttribute("result",  engine.nextPrime(min, max));
			} 
			catch (Exception e)
			{
				
				request.setAttribute("min", request.getParameter("min"));
				request.setAttribute("error", e.getMessage());
			}
			
			request.setAttribute("min", min);
			request.setAttribute("max", max);
			
		} 
		
		this.getServletContext().getRequestDispatcher("/Prime.jspx").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
