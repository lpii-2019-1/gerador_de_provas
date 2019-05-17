package gerador_provas.model;

public class Questao
{
  private Origem origem;
  private Area area;
  private Disciplina disciplina;
  private String enunciado;
  private Alternativa[] alternativa;
  private String imagem;
  
  
  
  public String getEnunciado() { return enunciado; }
  
  public void setEnunciado(String enunciado) {this.enunciado = enunciado; }
  
  public Origem getOrigem() {return origem;}
  
  public void setOrigem(Origem origem) { this.origem = origem; }
  
  public Area getArea() { return area; }
  
  public void setArea(Area area) { this.area = area; }
  
  public Disciplina getDisciplina() { return disciplina; }
  
  public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }
  
  public String getImagem() { return imagem; }
  
  public void setImagem(String imagem) { this.imagem = imagem; }
  
  public Alternativa[] getAlternativa() { return this.alternativa;}
  
  public void setAlternativa(Alternativa[] alternativa) { this.alternativa = alternativa; }
  


  public Questao(String enunciado, Alternativa[] alternativa, Origem origem, Area area, Disciplina disciplina) {
	    this.enunciado = enunciado;
	    this.origem = origem;
	    this.area = area;
	    this.disciplina = disciplina;
	    this.alternativa = alternativa;
  }  
  
}