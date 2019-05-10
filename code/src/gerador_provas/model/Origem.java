package gerador_provas.model;


public class Origem {
	private String origem;
	private int ano;
	
	
	public String getOrigem() { return origem; }
	
	public void setOrigem(String origem) { this.origem = origem; }

	public int getAno() { return ano; }

	public void setAno(int ano) { this.ano = ano; }
	
	public Origem(String origem, int ano) {
		this.origem = origem;
		this.ano = ano;
	}
	
	
	
	
	
}
