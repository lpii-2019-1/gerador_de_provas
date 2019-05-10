package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Questao;


public class QuestaoDAO {
	private Connection conexao;
	private PreparedStatement stm;
	
	public QuestaoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void cadastrar(Questao questao) {
		String sql = "insert into questao (professor_cpf, idarea, iddisciplina, idorigem) values (?,?,?,?,?)";
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
