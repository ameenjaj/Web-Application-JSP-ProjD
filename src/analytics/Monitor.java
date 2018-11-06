package analytics;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Monitor
 *
 */
@WebListener
public class Monitor implements ServletRequestListener, HttpSessionListener {


	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
    	HttpServletRequest httpReq = (HttpServletRequest) sre.getServletRequest();

    	if (httpReq.getRequestURI().contains("Drone")) {
    		addToContext(sre.getServletContext(), "droneUsage");
    		addToContext(sre.getServletContext(), "totalUsage");
    	}
    	else if (httpReq.getRequestURI().contains("Prime.do")) {
    		addToContext(sre.getServletContext(), "primeUsage");
    		addToContext(sre.getServletContext(), "totalUsage");
    	}
    	else if (httpReq.getRequestURI().contains("Gps.do")) {
    		addToContext(sre.getServletContext(), "gpsUsage");
    		addToContext(sre.getServletContext(), "totalUsage");
    	}
    	else if (httpReq.getRequestURI().contains("Ride.do")) {
    		addToContext(sre.getServletContext(), "rideUsage");
    		addToContext(sre.getServletContext(), "totalUsage");
    	}
    	else if (httpReq.getRequestURI().contains("Sis.do")) {
    		addToContext(sre.getServletContext(), "sisUsage");
    		addToContext(sre.getServletContext(), "totalUsage");
    	}
    	

    }
    
    private void addToContext(ServletContext context, String name) {
		if (context.getAttribute(name) == null) {
			context.setAttribute(name, 1);
		} else {
			context.setAttribute(name, (Integer)context.getAttribute(name) + 1);
		}	
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    }
	
}
