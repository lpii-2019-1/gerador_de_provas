package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Professor;



public class ProfessorDAO {
    private Connection conexao;
	private PreparedStatement stmt;
	public ProfessorDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void cadastrar(Professor oProfessor) {
		String sql = "INSERT INTO professor (cpf, nome, instituicao, email, senha) VALUES (?, ?, ?, ?, ?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, oProfessor.getCpf());
			stmt.setString(2, oProfessor.getNome());
			stmt.setString(3, oProfessor.getInstituicao());
			stmt.setString(4, oProfessor.getEmail());
			stmt.setString(5, oProfessor.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException("Erro: " + e);
		}	
	}
	
	public Professor pesquisar(Professor professor) {
		String sql = "select * from professor where cpf = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, professor.getCpf());
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				Professor professorResul = new Professor(rs.getLong("cpf"),rs.getString("nome"), rs.getString("instituicao"), rs.getString("email"), rs.getString("senha"));
				stmt.close();
	            return professorResul;
			}
			else { 
				Professor professorResul = new Professor(0, null, null, null, null);
				stmt.close();
	            return professorResul;
			}
			
            
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	} 
	
	public Professor pesquisarCpf(long cpf) {
		String sql = "select * from professor where cpf = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Professor professor_cpf = new Professor(rs.getLong("cpf"), rs.getString("nome"), rs.getString("instituicao"), rs.getString("email"), rs.getString("senha"));
				return professor_cpf;
			}
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	
}