package servelts;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Pessoa;
import models.Telefone;

/**
 * Servlet implementation class UsuarioLogin
 */
@WebServlet("/UsuarioLogin")
public class UsuarioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Pessoa pessoa = new Pessoa();
		pessoa.setEmail(request.getParameter("email"));
		pessoa.setSenha(request.getParameter("senha"));
		pessoa = pessoa.login();
		String status;

		if (pessoa != null) {
			Telefone telefone = new Telefone();
			pessoa.setTelefones(telefone.listAll(pessoa));
			HttpSession session = request.getSession(true);
			session.setAttribute("pessoa", pessoa);
			session.setAttribute("logado", true);
		
			status = "1";

		} else {
			status = "0";

		}
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		out.write(status);
		out.close();

	}

}
