package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Questao;


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
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
