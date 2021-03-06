package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Engine;

/**
 * Servlet implementation class Sis
 */
@WebServlet("/Sis.do")
public class Sis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String calc = request.getParameter("calc");
		
		if (calc != null) {
			String prefix = request.getParameter("prefix");
			String minGpa = request.getParameter("minGpa");
			String sortBy = request.getParameter("sortBy");
			
			request.setAttribute("prefix", prefix);
			request.setAttribute("minGpa", minGpa);
			request.setAttribute("sortBy", sortBy);

			try
			{
				Engine engine = Engine.getInstance();
				request.setAttribute("result",  engine.getSIS(prefix, sortBy, minGpa));
			} 
			catch (Exception e)
			{
				request.setAttribute("error", e.getMessage());
			}
			
			
		}
		this.getServletContext().getRequestDispatcher("/Sis.jspx").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
