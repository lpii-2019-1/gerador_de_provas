package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import gerador_provas.conexao.Conexao;
import gerador_provas.model.Prova;
import gerador_provas.model.Tipo;


public class ProvaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ProvaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public Prova cadastrar(Prova prova) {
		String sql = "insert into prova (professor_cpf, cabecalho) values (?,?)";
		try {
			stmt = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, prova.getProfessor().getCpf());
			stmt.setString(2, prova.getCabecalho());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			stmt.setInt(1,rs.getInt(1));
			prova.setIdprova(rs.getInt(1));
			
			stmt.close();
			
			return prova;
			
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Prova pesquisar(Prova prova) {
		String sql = "select * from prova where professor_cpf = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, prova.getProfessor().getCpf());
			ResultSet rs = stmt.executeQuery();
			
			Prova provaResul = new Prova();

			if(rs.next()) {	
				
				provaResul.setIdprova(rs.getInt("idprova"));

	            ProfessorDAO professorDAO = new ProfessorDAO();
				provaResul.setProfessor(professorDAO.pesquisarCpf(rs.getLong("professor_cpf")));
				
				provaResul.setCabecalho(rs.getString("cabecalho"));
			}
			
			stmt.close();
			
			return provaResul;
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
