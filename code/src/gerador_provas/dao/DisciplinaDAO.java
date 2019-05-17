package gerador_provas.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Disciplina;
import gerador_provas.model.Origem;



public class DisciplinaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public void DisicplinaDAO() {
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
		
		// Buscar origem
		public Origem pesquisar(Disciplia disciplina) {
			String sql = "select * from origem where origem = ? and ano = ?";
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, disciplina.getDisicplina());
				ResultSet rs = stmt.executeQuery();
	            Origem novaOrigem = new Origem();
	            
	            if (rs.next()) {
	                novaOrigem.setIdorigem(rs.getInt("idorigem"));
	                novaOrigem.setOrigem(rs.getString("origem"));
	                novaOrigem.setAno(rs.getInt("ano"));
	            }
	            stmt.close();
	            return novaOrigem;
	            	
			}catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	
	
	
}
