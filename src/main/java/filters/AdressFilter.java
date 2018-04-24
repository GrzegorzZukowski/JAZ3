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



@WebFilter("/adress.jsp")
public class AdressFilter implements Filter {

    public AdressFilter() {
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();								//sesja potrzebna do zapamiêtania wczytanych parametrów
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String wasredirect = httpRequest.getParameter("wasRedirect");
		System.out.println("wasRedirest = " + wasredirect);
		
		String firstname = httpRequest.getParameter("firstName");
		String surname = httpRequest.getParameter("surname");
		String pesel = httpRequest.getParameter("pesel");

		if (Boolean.parseBoolean(wasredirect) != true) {
			if(CheckText.isEmpty(firstname) || CheckText.isEmpty(surname) || CheckText.isEmpty(pesel)){
				httpResponse.sendRedirect("/person.jsp?wasRedirect=true");
			}
		}
		chain.doFilter(request, response);	
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
