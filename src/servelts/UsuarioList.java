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
 * Servlet implementation class UsuarioList
 */
@WebServlet("/UsuarioList")
public class UsuarioList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioList() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Chamada do metodo de listagem de pessoas e construindo um array com oq foi retonado
		Pessoa pessoa = new Pessoa();
		Telefone telefone = null;

		ArrayList<Pessoa> pessoas = pessoa.list();

		for (int i = 0; i < pessoas.size(); i++) {
			telefone = new Telefone();
			pessoas.get(i).setTelefones(telefone.listAll(pessoas.get(i)));

		}
		//transformando o array de pessoa em json e retornando para js
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		String info = gson.toJson(pessoas);
		out.write(info);
		out.close();

	}

}
