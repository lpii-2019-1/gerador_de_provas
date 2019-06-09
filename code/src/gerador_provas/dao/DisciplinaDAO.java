package gerador_provas.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Disciplina;
import java.sql.SQLException;


public class DisciplinaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public DisciplinaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	// Cadastrar
		public Disciplina cadastrar(Disciplina disciplina) {
			String sql = "insert into disciplina (disciplina) values (?)";
			try {
				stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, disciplina.getDisciplina());
				stmt.execute();
				
				ResultSet rs = stmt.getGeneratedKeys();
				rs.next();
				disciplina.setIddisciplina(rs.getInt(1));
				
				stmt.close();
				
				return disciplina;
				
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
		
		public Disciplina pesquisarId(int iddisciplina) {
			String sql = "select * from disciplina where iddisciplina = ?";
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setInt(1, iddisciplina);
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
		public Disciplina atualizar(Disciplina disciplina) {
			String sql = "update disciplina set disciplina = ? where iddisciplina = ?";
			try {
                            System.out.println(disciplina.getDisciplina());
				stmt = conexao.prepareStatement(sql);
                                stmt.setString(1, disciplina.getDisciplina());
                                stmt.setInt(2, disciplina.getIddisciplina());
				
				
				stmt.execute();
				stmt.close();
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
                        
                        
			
			return disciplina;
			
		}
                public Disciplina deletar(Disciplina disciplina) {
			String sql = "delete from disciplina where iddisciplina = ?";
			try {
                            System.out.println(disciplina.getDisciplina());
				stmt = conexao.prepareStatement(sql);
                                stmt.setInt(1, disciplina.getIddisciplina());
				
				
				stmt.execute();
				stmt.close();
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
                        
                        
			
			return disciplina;
			
		}
	
}
