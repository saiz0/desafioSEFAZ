package models;

import java.util.ArrayList;

import controllers.PessoaDAO;



public class Pessoa {
	
	private String nome, email, senha, id; 	
	private ArrayList<Telefone> telefones;
	
	public void create() {
		new PessoaDAO().create(this);
	}
		
	//sets e gets
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(ArrayList<Telefone> telefones) {
		this.telefones = telefones;
	}


	
	
	

}
