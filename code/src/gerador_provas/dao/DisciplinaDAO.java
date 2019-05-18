package gerador_provas.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Disciplina;




public class DisciplinaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public DisciplinaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	// Cadastrar
		public void cadastrar(Disciplina disciplina) {
			String sql = "insert into disciplina (disciplina) values (?)";
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, disciplina.getDisciplina());
				stmt.execute();
				stmt.close();
				
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		// Buscar disicplina
		public Disciplina pesquisar(Disciplina disciplina) {
			String sql = "select * from disciplina where disciplina = ?";
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, disciplina.getDisciplina());
				ResultSet rs = stmt.executeQuery();
	            Disciplina novaDisicplina = new Disciplina();
	            
	            if (rs.next()) {
	            	novaDisicplina.setIddisciplina(rs.getInt("iddisciplina"));
	            	novaDisicplina.setDisciplina(rs.getString("disciplina"));
	            	
	            }
	            stmt.close();
	            return novaDisicplina;
	            	
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	
}
