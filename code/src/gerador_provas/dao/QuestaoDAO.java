package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Questao;


public class QuestaoDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public QuestaoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void cadastrar(Questao questao) {
		String sql = "insert into questao (professor_cpf, idarea, iddisciplina, idorigem) values (?,?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			//stmt.setInt(1, );
			stmt.setInt(2, questao.getArea().getIdarea());
			//stmt.setInt(2, aluno.getCidade().getIdCidade());
			stmt.setInt(3,questao.getDisciplina().getIddisciplina());
			stmt.setString(4, questao.getOrigem().getIdorigem());
			stmt.setBoolean(5, alternativa.getCorreta());
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
