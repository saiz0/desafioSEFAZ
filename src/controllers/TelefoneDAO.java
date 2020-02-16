package controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.BancoDados;
import models.Pessoa;
import models.Telefone;

public class TelefoneDAO {

	public void create(Pessoa pessoa) {
		BancoDados.conectar();

		for (Telefone telefone : pessoa.getTelefones()) {
			BancoDados.enviarDados("CALL TelefoneCreate('" + pessoa.getEmail() + "','" + telefone.getDdd() + "','"
					+ telefone.getNumero() + "','" + telefone.getTipo() + "')");
		}
		BancoDados.fechar();

	}

	public void update(Telefone telefone) {
		BancoDados.conectar();
		try {
			BancoDados.enviarDados("CALL TelefoneUpdate('" + telefone.getId() + "','" + telefone.getDdd() + "','"
					+ telefone.getNumero() + "','" + telefone.getTipo() + "')");
			BancoDados.fechar();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void delete(Telefone telefone) {
		BancoDados.conectar();
		BancoDados.enviarDados("CALL TelefoneDelete('" + telefone.getId() + "')");
		BancoDados.fechar();

	}

	public Telefone date(Telefone telefone) {

		BancoDados.conectar();
		ResultSet resultSet = null;
		resultSet = BancoDados.receberDados("CALL TelefoneDate('" + telefone.getId() + "')");

		try {
			if (resultSet.next()) {
				telefone = new Telefone();
				telefone.setId(resultSet.getString("idTelefone"));
				telefone.setDdd(Integer.parseInt(resultSet.getString("ddd")));
				telefone.setNumero(resultSet.getString("numero"));
				telefone.setTipo(resultSet.getString("tipo"));

			}

		} catch (SQLException e) {

		}
		BancoDados.fechar();
		return telefone;
	}

	public ArrayList<Telefone> listAll(Pessoa pessoa) {
		Telefone telefone = null;
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();

		BancoDados.conectar();
		ResultSet resultSet = null;
		resultSet = BancoDados.receberDados("CALL TelefoneList('" + pessoa.getId() + "')");
		try {
			while (resultSet.next()) {
				telefone = new Telefone();
				telefone.setId(resultSet.getString("idTelefone"));
				telefone.setDdd(Integer.parseInt(resultSet.getString("ddd")));
				telefone.setNumero(resultSet.getString("numero"));
				telefone.setTipo(resultSet.getString("tipo"));
				telefones.add(telefone);
			}

		} catch (SQLException e) {

		}
		BancoDados.fechar();
		return telefones;
	}

}
