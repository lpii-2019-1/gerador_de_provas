package gerador_provas.model;

import java.util.ArrayList;
import java.util.List;

import gerador_provas.dao.QuestaoDAO;

public class Tipo {
	private Prova prova;
	private int idtipo;
	private List<Questao> questoes = new ArrayList<Questao>();
	private int posicao;
	private Alternativa[] alternativas;
	private String letra;
	
	public Prova getProva() {
		return prova;
	}
	public void setProva(Prova prova) {
		this.prova = prova;
	}
	public int getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(int idtipo) {
		this.idtipo = idtipo;
	}
	public List<Questao> getQuestoes() {
		return questoes;
	}
	public void setQuestoes(Questao questao) {
		this.questoes = (List<Questao>) questao;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public Alternativa[] getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(Alternativa[] alternativas2) {
		this.alternativas = alternativas2;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	public void adicionaQuestao(int idquestao) {
		QuestaoDAO questaoDAO = new QuestaoDAO();
		Questao questao = questaoDAO.pesquisaId(idquestao);
		this.questoes.add(questao);
	}
}
