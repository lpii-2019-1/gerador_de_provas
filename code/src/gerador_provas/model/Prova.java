package gerador_provas.model;

import java.util.ArrayList;

import gerador_provas.dao.QuestaoDAO;

public class Prova {
	private int idprova;
	private Professor professor;
	private String cabecalho;
	private ArrayList<Questao> questoes;
	private int tipos;
	
	public int getIdprova() { return idprova; }
	
	public void setIdprova(int idprova) { this.idprova = idprova; }
	
	public Professor getProfessor() { return professor; }

	public void setProfessor(Professor professor) { this.professor = professor; }
	
	public String getCabecalho() { return cabecalho; }
	
	public void setCabecalho(String cabecalho) { this.cabecalho = cabecalho; }
	
	public ArrayList<Questao> getQuestoes() {	return questoes; }
	
	public void setQuestoes(ArrayList<Questao> questoes) { this.questoes = questoes; }

	public int getTipos() { return tipos; }

	public void setTipos(int tipos) {this.tipos = tipos;}
	
	public void adicionaQuestao(int idquestao) {
		QuestaoDAO questaoDAO = new QuestaoDAO();
		ArrayList<Questao> questoes = new ArrayList<Questao>();
		
		Questao questao = new Questao();
		
		questao = questaoDAO.pesquisaId(idquestao);
		questoes.add(questao);
		this.setQuestoes(questoes);
		
	}
}
