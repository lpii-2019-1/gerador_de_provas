package gerador_provas.model;

public class Questao
{
  private Origem origem;
  private String area;
  private String disciplina;
  private String enunciado;
  private Alternativa[] alternativa;
  private String imagem;
  
  
  
  public String getEnunciado() { return enunciado; }
  
  public void setEnunciado(String enunciado) {this.enunciado = enunciado; }
  
  public Origem getOrigem() {return origem;}
  
  public void setOrigem(Origem origem) { this.origem = origem; }
  
  public String getArea() { return area; }
  
  public void setArea(String area) { this.area = area; }
  
  public String getDisciplina() { return disciplina; }
  
  public void setDisciplina(String disciplina) { this.disciplina = disciplina; }
  
  public String getImagem() { return imagem; }
  
  public void setImagem(String imagem) { this.imagem = imagem; }
  
  public Alternativa[] getAlternativa() { return alternativa;}
  
  public void setAlternativa(Alternativa[] alternativa) { this.alternativa = alternativa; }
  


  public Questao(String enunciado, Origem origem, String area, String disciplina) {
	    this.enunciado = enunciado;
	    this.origem = origem;
	    this.area = area;
	    this.disciplina = disciplina;
  }  
  
}