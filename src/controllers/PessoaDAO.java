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
		resultSet = BancoDados.receberDados("CALL PessoaDate('" 
				+ idPessoa						
				+ "')");

		try {
			if (resultSet.next()) {
				pessoa = new Pessoa();
				pessoa.setId(resultSet.getString("idPessoa"));
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setEmail(resultSet.getString("nome"));

			}

		} catch (SQLException e) {

		}
		BancoDados.fechar();
		return pessoa;
	}

	public void create(Pessoa pessoa) {
		BancoDados.conectar();
		BancoDados.enviarDados("CALL PessoaCreate('" 
		+ pessoa.getNome() 
		+ "','" 
		+ pessoa.getEmail() 
		+ "','"				
		+ pessoa.getSenha()
		+ "')");
		BancoDados.fechar();

	}

	public void delete(Pessoa pessoa) {
		BancoDados.conectar();
		BancoDados.enviarDados("CALL PessoaDelete('" 
		+ pessoa.getId() 
		+ "')");
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
				pessoa.setEmail(resultSet.getString("nome"));
				pessoas.add(pessoa);

			}

		} catch (SQLException e) {

		}
		BancoDados.fechar();
		return pessoas;
	}
}