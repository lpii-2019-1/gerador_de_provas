package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import gerador_provas.conexao.Conexao;
import gerador_provas.model.Prova;


public class ProvaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ProvaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public Prova cadastrar(Prova prova) {
		String sql = "insert into prova (professor_cpf, cabecalho) values (?,?)";
		try {
			stmt = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, prova.getProfessor().getCpf());
			stmt.setString(2, prova.getCabecalho());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			
			prova.setIdprova(rs.getInt(1));
			stmt.close();
			
			return prova;
			
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return prova;
		
	}
}
