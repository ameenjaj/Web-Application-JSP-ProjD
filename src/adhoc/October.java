package adhoc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/*")
public class October implements Filter {

	private String[] notAvaliableServices= {"Ride.do"};


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
			System.out.println("Before");
			HttpServletRequest httpReq = (HttpServletRequest) request;
			HttpServletResponse httpRes = (HttpServletResponse) response;

			for (String service: notAvaliableServices)
				if (httpReq.getRequestURI().toString().contains(service)) {
					
					httpRes.sendRedirect(String.format("%s/NotAvaliable?msg='%s "
							+ "service is not avaliable'", httpReq.getContextPath(), service));
					return;
				} 
			
			if (httpReq.getRequestURI().toString().contains("Sis.do"))
				if(httpReq.getParameter("sortBy") != null && !httpReq.getParameter("sortBy").equals("NONE")) {
					httpRes.sendRedirect(String.format("%s/NotAvaliable?msg='Sorting Service is not avaliable'"
							+ "service is not avaliable'", httpReq.getContextPath()));
					return;
				}
			
			chain.doFilter(request, response);
			
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
