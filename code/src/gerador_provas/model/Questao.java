package gerador_provas.model;
import java.sql.Blob;

public class Questao
{
  private Professor professor;
  private Origem origem;
  private Area area;
  private Disciplina disciplina;
  private String enunciado;
  private Alternativa[] alternativa;
  private Blob imagem;

  
  
  public Professor getProfessor() {return professor;}
  
  public void setProfessor(Professor professor) {this.professor = professor;}
  
  public String getEnunciado() { return enunciado; }
  
  public void setEnunciado(String enunciado) {this.enunciado = enunciado; }
  
  public Origem getOrigem() {return origem;}
  
  public void setOrigem(Origem origem) { this.origem = origem; }
  
  public Area getArea() { return area; }
  
  public void setArea(Area area) { this.area = area; }
  
  public Disciplina getDisciplina() { return disciplina; }
  
  public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }
  
  public Blob getImagem() { return imagem; }
  
  public void Blob(Blob imagem) { this.imagem = imagem; }
  
  public Alternativa[] getAlternativa() { return this.alternativa;}
  
  public void setAlternativa(Alternativa[] alternativa) { this.alternativa = alternativa; }
  


  public Questao(Professor professor, String enunciado, Alternativa[] alternativa, Origem origem, Area area, Disciplina disciplina) {
	  this.professor = professor;  
	  this.enunciado = enunciado;
	  this.origem = origem;
	  this.area = area;
	  this.disciplina = disciplina;
	  this.alternativa = alternativa;
  }  
  
}