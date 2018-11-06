package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Engine;

/**
 * Servlet implementation class Gps
 */
@WebServlet("/Gps.do")
public class Gps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
Engine engine = Engine.getInstance();
		
		String calc = request.getParameter("calc");
		
		if (calc != null) {
			String lon1 = request.getParameter("lon1");
			String lat1 = request.getParameter("lat1");
			String lon2 = request.getParameter("lon2");
			String lat2 = request.getParameter("lat2");
			request.setAttribute("lon1", request.getParameter("lon1"));
			request.setAttribute("lat1", request.getParameter("lat1"));
			request.setAttribute("lon2", request.getParameter("lon2"));
			request.setAttribute("lat2", request.getParameter("lat2"));
			

			try
			{
				request.setAttribute("result",  engine.getDistance(lon1, lat1, lon2, lat2));
			} 
			catch (Exception e)
			{
				request.setAttribute("error", e.getMessage());
			}
			
			
			
		} 
		
		
		this.getServletContext().getRequestDispatcher("/Gps.jspx").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
