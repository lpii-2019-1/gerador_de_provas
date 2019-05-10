/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bruno
 */
public class ProfessorDAO {
    private Connection conexao;
	private PreparedStatement stmt;
	
	public ProfessorDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserirProfessor() {
		String sql = "INSERT INTO professor (cpf, nome, email, senha) VALUES (?, ?, ?, ?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, Professor.getCpf());
			stmt.setString(2, Professor.getNome());
			stmt.setString(3, Professor.getEmail());
			stmt.setInt(4, Professor.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro: " + e);
		}
		
	}
}
