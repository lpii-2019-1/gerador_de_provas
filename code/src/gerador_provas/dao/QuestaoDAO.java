package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import gerador_provas.conexao.Conexao;
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
			stmt= conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1,questao.getProfessor().getCpf() );
			stmt.setInt(2, questao.getArea().getIdarea());
			stmt.setInt(3,questao.getDisciplina().getIddisciplina());
			stmt.setInt(4, questao.getOrigem().getIdorigem());
			stmt.setString(5, questao.getEnunciado());
			stmt.setBlob(6,questao.getImagem());
			stmt.execute(); 
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			System.out.println(rs.getInt(1));
			
			AlternativaDAO alternativaDAO = new AlternativaDAO();
			questao.setIdquestao(rs.getInt(1));
			
			// Passa cada uma das alterntivas para serem gravadas no BD.
			// O cont serve como id auto increment das alternativas;
			int cont = 0;
			for(int i=0; i < questao.getAlternativas().length; i++) {	
				cont ++;
				questao.getAlternativas()[i].setIdAlternativa(cont);
				alternativaDAO.cadastrar(questao.getAlternativas()[i], questao);
			}
			
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
	}
	
	public Questao atualizar(Questao questao) {
	
		
		String sql = "update questao set idarea = ?, iddisciplina = ?, idorigem = ?, enunciado = ?, imagem = ? where idquestao = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, questao.getArea().getIdarea());
			stmt.setInt(2, questao.getDisciplina().getIddisciplina());
			stmt.setInt(3, questao.getOrigem().getIdorigem());
			stmt.setString(4,questao.getEnunciado());
			stmt.setBlob(5, questao.getImagem());
			stmt.setInt(6, questao.getIdquestao());
			stmt.execute();
			stmt.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return questao;
		
	}
	
}
	

