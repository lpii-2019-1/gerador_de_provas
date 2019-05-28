package gerador_provas.model;

public class Disciplina {
	private int iddisciplina;
	private String disciplina;
	
	
	public Disciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public Disciplina(int iddisciplina, String disciplina) {
		this.iddisciplina = iddisciplina;
		this.disciplina = disciplina;
	}
	
	public Disciplina() {
		
	}
	
	public int getIddisciplina() {
		return iddisciplina;
	}
	public void setIddisciplina(int iddisciplina) {
		this.iddisciplina = iddisciplina;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	
}
