package gerador_provas.model;
import java.sql.Blob;

public class Questao
{
  private int idquestao;
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
  
  public void SetImagem(Blob imagem) { this.imagem = imagem; }
  
  public Alternativa[] getAlternativa() { return this.alternativa;}
  
  public void setAlternativa(Alternativa[] alternativa) { this.alternativa = alternativa; }
  

 
 public Questao(Professor professor, Area area, Disciplina disciplina, Origem origem, String enunciado, Alternativa[] alternativas) {
	  this.professor.setCpf(professor.getCpf());
	  this.origem.setIdorigem(origem.getIdorigem());
	  this.area.setIdarea(area.getIdarea());
	  this.disciplina.setIddisciplina(disciplina.getIddisciplina());
	  this.enunciado = enunciado;
	  this.alternativa = alternativas;
 }
 
 public Questao() {};

public int getIdquestao() {
	return idquestao;
}

public void setIdquestao(int idquestao) {
	this.idquestao = idquestao;
}
  
}