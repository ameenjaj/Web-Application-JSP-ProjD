package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin.do")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (this.getServletContext().getAttribute("totalUsage") != null ) {
			int total = (int) this.getServletContext().getAttribute("totalUsage");
			int primeUsage = (int) this.getServletContext().getAttribute("primeUsage");
			int gpsUsage = (int) this.getServletContext().getAttribute("gpsUsage");
			int droneUsage = (int) this.getServletContext().getAttribute("droneUsage");
			int rideUsage = (int) this.getServletContext().getAttribute("rideUsage");
			int sisUsage = (int) this.getServletContext().getAttribute("sisUsage");
			
			request.setAttribute("totalUsage", total);
			request.setAttribute("primeUsage", ((float)primeUsage / total) * 100);
			request.setAttribute("gpsUsage", ((float)gpsUsage / total) * 100);
			request.setAttribute("droneUsage", ((float)droneUsage / total) * 100);
			request.setAttribute("rideUsage", ((float)rideUsage / total) * 100);
			request.setAttribute("sisUsage", ((float)sisUsage / total) * 100);
		}
		this.getServletContext().getRequestDispatcher("/Admin.jspx").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
