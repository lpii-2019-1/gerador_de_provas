package gerador_provas.model;


public class Origem {
	private int idorigem;
	private String origem;
	private int ano;
	
	
	public String getOrigem() { return origem; }
	
	public void setOrigem(String origem) { this.origem = origem; }

	public int getAno() { return ano; }

	public void setAno(int ano) { this.ano = ano; }

	public int getIdorigem() { return idorigem; }

	public void setIdorigem(int idorigem) { this.idorigem = idorigem; }
	
	
	public Origem(int idorigem) {this.idorigem = idorigem;}
	
	public Origem(String origem, int ano) {
		this.origem = origem;
		this.ano = ano;
	}
	
	public Origem(int idorigem, String origem, int ano) {
		this.idorigem = idorigem;
		this.origem = origem;
		this.ano = ano;
	}
	
	public Origem() {	}


	
	
	
	
	
}
