import java.util.ArrayList;

import models.Pessoa;
import models.Telefone;

public class main {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("a");		
		pessoa.setEmail("a");
		pessoa.setSenha("a");
		
		Telefone telefone = new Telefone();
		telefone.setNumero("aa");
		telefone.setDdd(00);
		telefone.setTipo("Numero");
		
		Telefone celular = new Telefone();
		celular.setNumero("aa");
		celular.setDdd(00);
		celular.setTipo("Celular");
		
		ArrayList<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(telefone);
		telefones.add(celular);
		pessoa.setTelefones(telefones);
		pessoa.create();
		
	}

}
