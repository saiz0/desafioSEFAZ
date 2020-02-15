package servelts;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FiltroSeguranca")

@WebFilter(urlPatterns = { "/dashboard.jsp" })

public class FiltroSeguranca implements Filter {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FiltroSeguranca() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		boolean logado = false;
		if (session.getAttribute("logado") != null) {
			logado = (boolean) (session.getAttribute("logado"));
		}
		if (logado) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect("index.jsp");

		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
