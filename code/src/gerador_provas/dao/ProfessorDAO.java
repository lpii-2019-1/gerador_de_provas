package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Professor;



public class ProfessorDAO {
    private Connection conexao;
	private PreparedStatement stmt;
	public ProfessorDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserirProfessor(Professor oProfessor) {
		String sql = "INSERT INTO professor (cpf, nome, email, senha) VALUES (?, ?, ?, ?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, oProfessor.getCpf());
			stmt.setString(2, oProfessor.getNome());
			stmt.setString(3, oProfessor.getEmail());
			stmt.setString(4, oProfessor.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro: " + e);
		}
		
	}
}