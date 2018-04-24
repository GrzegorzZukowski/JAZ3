package filters;

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
import javax.servlet.http.HttpSession;

import service.CheckText;


@WebFilter("/success.jsp")
public class SuccessFilter implements Filter {


    public SuccessFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();						//sesja potrzebna do zapamiêtania wczytanych parametrów
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
				
		String zipcode = httpRequest.getParameter("zipCode");
		String city = httpRequest.getParameter("city");
		String street = httpRequest.getParameter("street");
		String housenumber = httpRequest.getParameter("houseNumber");
		String localnumber = httpRequest.getParameter("localNumber");
		String phonenumber = httpRequest.getParameter("phoneNumber");
		
		if(CheckText.isEmpty(zipcode) || CheckText.isEmpty(city) || CheckText.isEmpty(housenumber) || CheckText.isEmpty(localnumber)|| CheckText.isEmpty(street) || CheckText.isEmpty(phonenumber) ){
				httpResponse.sendRedirect("/adress.jsp?wasRedirect=true");
		}
		chain.doFilter(request, response);	
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
