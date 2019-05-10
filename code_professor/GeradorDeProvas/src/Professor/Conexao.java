/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Professor;

/**
 *
 * @author bruno
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static final String DSN = "jdbc:mysql://www.adrianobraga.com.br/adrianob_bd42019";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	public Connection getConexao() {
		try {
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
}
