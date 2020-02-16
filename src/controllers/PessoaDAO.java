package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.BancoDados;
import models.Pessoa;

public class PessoaDAO {

	public Pessoa date(String idPessoa) {

		Pessoa pessoa = null;

		BancoDados.conectar();
		ResultSet resultSet = null;
		resultSet = BancoDados.receberDados("CALL PessoaDate('" + idPessoa + "')");

		try {
			if (resultSet.next()) {
				pessoa = new Pessoa();
				pessoa.setId(resultSet.getString("idPessoa"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setEmail(resultSet.getString("email"));

			}

		} catch (SQLException e) {

		}
		BancoDados.fechar();
		return pessoa;
	}

	public Pessoa login(Pessoa pessoa) {

		BancoDados.conectar();
		ResultSet resultSet = null;
		resultSet = BancoDados
				.receberDados("CALL PessoaLogin('" + pessoa.getEmail() + "','" + pessoa.getSenha() + "')");

		try {
			if (resultSet.next()) {
				pessoa = new Pessoa();
				pessoa.setId(resultSet.getString("idPessoa"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setEmail(resultSet.getString("email"));

			} else {
				pessoa = null;
			}

		} catch (SQLException e) {

		}
		BancoDados.fechar();
		return pessoa;
	}

	public void create(Pessoa pessoa) {
		BancoDados.conectar();
		try {
			BancoDados.enviarDados("CALL PessoaCreate('" + pessoa.getNome() + "','" + pessoa.getEmail() + "','"
					+ pessoa.getSenha() + "')");
			BancoDados.fechar();
			new TelefoneDAO().create(pessoa);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void update(Pessoa pessoa) {
		BancoDados.conectar();
		try {
			BancoDados.enviarDados("CALL PessoaUpdate('" 
					+ pessoa.getId() + "','" 
					+ pessoa.getNome() + "','" 
					+ pessoa.getEmail() + "','"
					+ pessoa.getSenha() + "')");
			BancoDados.fechar();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void delete(Pessoa pessoa) {
		BancoDados.conectar();
		BancoDados.enviarDados("CALL PessoaDelete('" + pessoa.getId() + "')");
		BancoDados.fechar();
	}

	public ArrayList<Pessoa> listAll() {
		Pessoa pessoa = null;
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

		BancoDados.conectar();
		ResultSet resultSet = null;
		resultSet = BancoDados.receberDados("CALL PessoaList()");

		try {
			while (resultSet.next()) {

				pessoa = new Pessoa();
				pessoa.setId(resultSet.getString("idPessoa"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setEmail(resultSet.getString("email"));
				pessoas.add(pessoa);
			}

		} catch (SQLException e) {

		}
		BancoDados.fechar();
		return pessoas;
	}
}
