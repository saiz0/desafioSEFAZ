package servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import models.Pessoa;
import models.Telefone;

/**
 * Servlet implementation class UsuarioUpdate
 */
@WebServlet("/UsuarioUpdate")
public class UsuarioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioUpdate() {
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
		//Recuperando a pessoa salva na session
		HttpSession session = request.getSession();
		Pessoa pessoa = (Pessoa) (session.getAttribute("pessoa"));
		try {
			//construindo os novos objetos para fazer update
			Telefone telefone = new Telefone();
			telefone.setId(request.getParameter("idTelefone"));
			telefone.setNumero(request.getParameter("celular"));
			telefone.setDdd(Integer.parseInt(request.getParameter("dddTelefone")));
			telefone.setTipo("Numero");

			Telefone celular = new Telefone();
			celular.setId(request.getParameter("idCelular"));
			celular.setNumero(request.getParameter("celular"));
			celular.setDdd(Integer.parseInt(request.getParameter("dddCelular")));
			celular.setTipo("Celular");

			ArrayList<Telefone> telefones = new ArrayList<Telefone>();
			telefones.add(telefone);
			telefones.add(celular);
			pessoa.setNome(request.getParameter("nome"));
			pessoa.setEmail(request.getParameter("email"));
			pessoa.setSenha(request.getParameter("senha"));
			pessoa.setTelefones(telefones);
			
			//chamda dos metodos de update
			celular.update();
			telefone.update();
			pessoa.update();
			pessoa.setSenha("");

			//salvando o update feito no usuario na session
			session.setAttribute("pessoa", pessoa);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
