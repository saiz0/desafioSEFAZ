import models.Pessoa;

public class main {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("aa");
		pessoa.setEmail("aaa");
		pessoa.setSenha("aaa");		
		pessoa.create();
		
	}

}
