package gerador_provas.dao;

import java.io.File;

import java.io.FileInputStream;
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
		String sql = "insert into questao (professor_cpf, idarea, iddisciplina, idorigem, imagem) values (?,?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,questao.getProfessor().getCpf() );
			stmt.setInt(2, questao.getArea().getIdarea());
			stmt.setInt(3,questao.getDisciplina().getIddisciplina());
			stmt.setString(4, questao.getOrigem().getOrigem());
			stmt.setBlob(5, questao.getImagem());
			stmt.execute(); 
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
	

