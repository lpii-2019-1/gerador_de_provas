package gerador_provas.model;



public class Questao
{
  private String enunciado;
  private String origem;
  private String area;
  private String disciplina;
  private String imagem;
  private Alternativa[] alternativa;
  
  private Questao(String enunciado, Alternativa alternativa, String origem, String area, String disciplina) {
    setEnunciado(enunciado);
    setAlternativa(alternativa);
    setArea(area);
    setDisciplina(disciplina);
    setOrigem(origem);
  }
  
  public String getEnunciado()
  {
    return enunciado;
  }
  
  public void setEnunciado(String enunciado) {
    this.enunciado = enunciado;
  }
  

  public String getOrigem() {
    return origem;
  }
  
  public void setOrigem(String origem) {
    this.origem = origem;
  }
  
  public String getArea() {
    return area;
  }
  
  public void setArea(String area) {
    this.area = area;
  }
  
  public String getDisciplina() {
    return disciplina;
  }
  
  public void setDisciplina(String disciplina) {
    this.disciplina = disciplina;
  }
  
  public String getImagem() {
    return imagem;
  }
  
  public void setImagem(String imagem) {
    this.imagem = imagem;
  }
  
  private String inserirQuestao(String enunciado,String origem, String area, String disciplina, Alternativa alternativa)
  {
    this.enunciado = enunciado;
    this.alternativa.add(alternativa);
    this.area = area;
    this.disciplina = disciplina;
    this.origem = origem;
    return "YES";
  }
}