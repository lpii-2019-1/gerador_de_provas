package gerador_provas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static final String DSN = "jdbc:mysql://www.adrianobraga.com.br/adrianob_bd42019?autoReconnect=true";
	private static final String USUARIO = "adrianob_bd42019";
	private static final String SENHA = "bd.04201905";
	
	public Connection getConexao() {
		try {
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
