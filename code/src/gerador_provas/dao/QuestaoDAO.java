package gerador_provas.dao;

import java.io.File;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.CidadeDAO;
import gerador_provas.conexao.Conexao;
import gerador_provas.model.Professor;
import gerador_provas.model.Questao;


public class QuestaoDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public QuestaoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void cadastrar(Questao questao) {
		String sql = "insert into questao (professor_cpf, idarea, iddisciplina, idorigem, enunciado, imagem) values (?,?,?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1,questao.getProfessor().getCpf() );
			stmt.setInt(2, questao.getArea().getIdarea());
			stmt.setInt(3,questao.getDisciplina().getIddisciplina());
			stmt.setInt(4, questao.getOrigem().getIdorigem());
			stmt.setString(5, questao.getEnunciado());
			stmt.setBlob(6,questao.getImagem());
			stmt.execute(); 
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
	public Questao pesquisar(Questao questao) {
		String sql = "select * from questao where enunciado = ?";
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, questao.getEnunciado());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				Questao questaoResul = new Questao();
				questaoResul.setIdquestao(rs.getInt("idquestao"));	
				
	
	            ProfessorDAO professorDAO = new ProfessorDAO();
	            questaoResul.setProfessor(professorDAO.pesquisarCpf(rs.getLong("professor_cpf")));
	                
	             
	            AreaDAO areaDAO = new AreaDAO();
	            questaoResul.setArea(areaDAO.pesquisarId(rs.getInt("idarea")));
	            
	            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	            questaoResul.setDisciplina(disciplinaDAO.pesquisarId(rs.getInt("iddisciplina")));
	            
	            OrigemDAO origemDAO = new OrigemDAO();
	            questaoResul.setOrigem(origemDAO.pesquisarId(rs.getInt("idorigem")));
	            
	            questaoResul.setEnunciado(rs.getString("enunciado"));
	            questaoResul.SetImagem(rs.getBlob("imagem"));
	            
	             stmt.close();
	             return questaoResul;
			}
			else {
				Questao questaoResul = new Questao();
				stmt.close();
	            return questaoResul;
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	} // Fim pesquisa
}
	

