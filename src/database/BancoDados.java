package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDados {
	private static Connection con = null;
	private static final String servidor = "localhost";
	private static final String basedados = "desafiosefaz";
	private static final String usuario = "root";
	private static final String senha = "";
	
	public static void conectar(){
		try {			
			new com.mysql.cj.jdbc.Driver();			
			con = DriverManager.getConnection("jdbc:mysql://"+ servidor + "/" + basedados, usuario, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void fechar() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet receberDados(String SQL) {
		ResultSet dados = null;
		
		try {
			Statement st = con.createStatement();
			dados = st.executeQuery(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dados;
	}
	
	public static void enviarDados(String SQL) {
		try {
			Statement st = con.createStatement();
			st.execute(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}



