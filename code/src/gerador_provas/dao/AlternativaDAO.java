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
	
	public void inserir(Alternativa alternativa, Questao questao) {
		String sql = "Insert into alternativa (idquestao, idalternativa, alternativa, imagem, correta) values (?,?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, alternativa.getIdQuestao());
			stmt.setInt(2, alternativa.getIdAlternativa());
			stmt.setString(3,alternativa.getAlternativa());
			stmt.setString(4, alternativa.getImagem());
			stmt.setBoolean(5, alternativa.getCorreta());
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
