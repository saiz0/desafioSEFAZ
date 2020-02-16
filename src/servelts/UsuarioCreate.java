package servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import models.Pessoa;
import models.Telefone;

/**
 * Servlet implementation class UsuarioCreate
 */
@WebServlet("/UsuarioCreate")
public class UsuarioCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioCreate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setEmail(request.getParameter("email"));
		pessoa.setSenha(request.getParameter("senha"));

		Telefone telefone = new Telefone();
		telefone.setNumero(request.getParameter("celular"));
		telefone.setDdd(Integer.parseInt(request.getParameter("dddTelefone")));
		telefone.setTipo("Numero");

		Telefone celular = new Telefone();
		celular.setNumero(request.getParameter("celular"));
		celular.setDdd(Integer.parseInt(request.getParameter("dddCelular")));
		celular.setTipo("Celular");

		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(telefone);
		telefones.add(celular);
		pessoa.setTelefones(telefones);
		pessoa.create();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write("true");
		out.close();

	}

}
