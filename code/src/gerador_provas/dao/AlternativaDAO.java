package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Disciplina;
import gerador_provas.model.Questao;
import java.sql.Blob;
import java.sql.SQLException;



public class AlternativaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public AlternativaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void cadastrar(Alternativa alternativa, Questao questao) {
		String sql = "Insert into alternativa (idquestao, idalternativa, alternativa, imagem, correta) values (?,?,?,?,?)";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,questao.getIdquestao());
			stmt.setInt(2, alternativa.getIdAlternativa());
			stmt.setString(3,alternativa.getAlternativa());
			stmt.setBlob(4, alternativa.getImagem());
			stmt.setBoolean(5, alternativa.getCorreta());
			stmt.execute(); 
			stmt.close();
		
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Alternativa pesquisar(Alternativa alternativa, Questao questao) {
		String sql = "select * from alternativa where idalternativa = ? and idquestao= ?";
		try {
			
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, alternativa.getIdAlternativa());
			stmt.setInt(2, questao.getIdquestao());
			ResultSet rs = stmt.executeQuery();
			
			
			if(rs.next()) {
				Alternativa alternativaResul = new Alternativa();
				alternativaResul.setIdQuestao(rs.getInt("idquestao"));
				alternativaResul.setIdAlternativa(rs.getInt("idalternativa"));
				alternativaResul.setAlternativa(rs.getString("alternativa"));
				alternativaResul.setImagem(rs.getBlob("imagem"));		
						
				stmt.close();
	            return alternativaResul;
			}
			else { 
				Alternativa alternativaResul = new Alternativa();
				stmt.close();
	            return alternativaResul;
			}	
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	     
                
            
	public Alternativa[] pesquisarId(int idquestao){
		String sql = "select * from alternativa where idquestao = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idquestao);
			ResultSet rs = stmt.executeQuery();
			Alternativa[] alternativas = new Alternativa[5];
			
			int cont = 0;
			while(rs.next()) {
				Alternativa alternativa =  new Alternativa();
				alternativa.setAlternativa(rs.getString("alternativa"));
				alternativa.setCorreta(rs.getBoolean("correta"));
				alternativa.setIdAlternativa(rs.getInt("idalternativa"));
				alternativa.setIdQuestao(rs.getInt("idquestao"));
				alternativa.setImagem(rs.getBlob("imagem"));
				alternativas[cont] = alternativa;
				cont++;
			}
			stmt.close();
			return alternativas;
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public  ArrayList<Alternativa> listar(Questao questoes){
		System.out.println(questoes.getIdquestao());
		
		String sql = "select * from alternativa where idquestao= ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, questoes.getIdquestao());
			ResultSet rs = stmt.executeQuery();
			
			 ArrayList<Alternativa> lista = new ArrayList<Alternativa>();
	            while (rs.next()) {
	            	Alternativa alternativaResul = new Alternativa();
					alternativaResul.setIdQuestao(rs.getInt("idquestao"));
					alternativaResul.setIdAlternativa(rs.getInt("idalternativa"));
					alternativaResul.setAlternativa(rs.getString("alternativa"));
					alternativaResul.setImagem(rs.getBlob("imagem"));	
	               
	                lista.add(alternativaResul);    
	            }
	            stmt.close();
	            return lista;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public Alternativa atualizar(Alternativa alternativa) {
		String sql = "update alternativa set alternativa = ?, imagem = ?, correta = ? where idalternativa = ?;";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, alternativa.getAlternativa());
			stmt.setBlob(2, alternativa.getImagem());
			stmt.setBoolean(3, alternativa.getCorreta());
			stmt.setInt(3, alternativa.getIdAlternativa());
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return alternativa;
		
	}
	  public void deletar(int idquestao) {
			String sql = "delete from alternativa where idquestao = ?;";
			try {
            	stmt = conexao.prepareStatement(sql);
                stmt.setInt(1, idquestao);
				stmt.execute();
				stmt.close();
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}