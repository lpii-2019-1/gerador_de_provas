package gerador_provas.model;

import java.util.ArrayList;

public class Tipo {
	private Prova prova;
	private int idtipo;
	private Questao[] questoes;
	private int posicao;
	private ArrayList<Alternativa> alternativas;
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
	public Questao getQuestoes() {
		return questoes;
	}
	public void setQuestoes(Questao[] questaos) {
		this.questoes = questaos;
	}
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	public Alternativa getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(ArrayList<Alternativa> arrayList) {
		this.alternativas = arrayList;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
}
