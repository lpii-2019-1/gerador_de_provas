package gerador_provas.model;

public class Prova {
	private int idprova;
	private Professor professor;
	private String cabecalho;
	private Questao questoes;
	
	public int getIdprova() { return idprova; }
	
	public void setIdprova(int idprova) { this.idprova = idprova; }
	
	public Professor getProfessor() { return professor; }

	public void setProfessor(Professor professor) { this.professor = professor; }
	
	public String getCabecalho() { return cabecalho; }
	
	public void setCabecalho(String cabecalho) { this.cabecalho = cabecalho; }
	
	public Questao getQuestoes() {	return questoes; }
	
	public void setQuestoes(Questao questoes) { this.questoes = questoes; }
	
	
}
