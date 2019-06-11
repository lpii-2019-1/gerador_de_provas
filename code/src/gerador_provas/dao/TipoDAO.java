package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import gerador_provas.conexao.Conexao;
import gerador_provas.model.Prova;
import gerador_provas.model.Tipo;

public class TipoDAO {
	
	private Connection conexao;
	private PreparedStatement stmt;
	
	public TipoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void cadastrar(Tipo tipo, Prova prova) {
		String sql = "inser into tipo(idprova,idtipo,idquestao,posicao,idalterantiva,letra) values (?,?,?,?,?,?)";
		
		try {
			stmt= conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, tipo.getProva().getIdprova());
			stmt.setInt(2,tipo.getIdtipo());
			stmt.setInt(3,tipo.getQuestoes().getIdquestao());
			stmt.setInt(4,tipo.getPosicao());
			stmt.setInt(5, tipo.getAlternativas().getIdAlternativa());
			stmt.setString(6, tipo.getLetra());
			
			stmt.execute(); 
			stmt.close();
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}	
	}
}
