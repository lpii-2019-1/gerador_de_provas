package gerador_provas;

public class Questao
{
  private String enunciado;
  private String[] alternativa;
  private String origem;
  private String area;
  private String disciplina;
  private String imagem;
  
  private Questao(String enunciado, String[] alternativa, String origem, String area, String disciplina) {
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
  
  public String[] getAlternativa() {
    return alternativa;
  }
  
  public void setAlternativa(String[] alternativa) {
    this.alternativa = alternativa;
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
  
  private String inserirQuestao(String enunciado, String[] alternativa, String origem, String area, String disciplina)
  {
    this.enunciado = enunciado;
    this.alternativa = alternativa;
    this.area = area;
    this.disciplina = disciplina;
    this.origem = origem;
    return "YES";
  }
}