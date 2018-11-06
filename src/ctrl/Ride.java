package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Engine;

/**
 * Servlet implementation class Ride
 */
@WebServlet("/Ride.do")
public class Ride extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String calc = request.getParameter("calc");
			
			if (calc != null) {
				String from = request.getParameter("from");
				String dest = request.getParameter("dest");
				
				request.setAttribute("from", from);
				request.setAttribute("dest", dest);

				try
				{
					Engine engine = Engine.getInstance();
					request.setAttribute("result",  engine.getTravelCost(from, dest));
				} 
				catch (Exception e)
				{
					request.setAttribute("error", e.getMessage());
				}
				
			} 
		
		
		this.getServletContext().getRequestDispatcher("/Ride.jspx").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
