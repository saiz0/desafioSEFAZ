package models;

import java.util.ArrayList;

import controllers.TelefoneDAO;

public class Telefone {
	private String numero, tipo, id; 		
	private int ddd;
	
	
	public ArrayList<Telefone> listAll(Pessoa pessoa) {
		return new TelefoneDAO().listAll(pessoa);
	}	
	public void update() {
		new TelefoneDAO().update(this);
	}
	//sets e gets
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
