package gerador_provas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import gerador_provas.conexao.Conexao;
import gerador_provas.model.Area;



public class AreaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public AreaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	// Cadastrar
	public void cadastrar(Area area) {
		String sql = "insert into area (area) values (?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, area.getArea());
			stmt.execute();
			stmt.close();
			
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Buscar area
	public Area pesquisar(String nomeArea) {
		String sql = "select * from area where area = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, nomeArea);
			ResultSet rs = stmt.executeQuery();
            Area area = new Area();
            
            if (rs.next()) {
                area.setIdarea(rs.getInt("idarea"));
                area.setArea(rs.getString("area"));   
            }
            stmt.close();
            return area;
            	
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	// Lista todas as áreas
	 public ArrayList<Area> listarTudo() {
		String sql = "select * from area";
		try {
			stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Area> lista = new ArrayList<Area>();
            
            while (rs.next()) {
                Area area = new Area();
                area.setIdarea(rs.getInt("idarea"));
                area.setArea(rs.getString("area"));

                lista.add(area);
            }
            stmt.close();
            return lista;
            
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	} 
	
}
