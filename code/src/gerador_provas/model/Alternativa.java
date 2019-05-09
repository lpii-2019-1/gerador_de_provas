package gerador_provas;

public class Alternativa {
  private String alternativa;
  private boolean correta;
  private String imagem;
  
  public Alternativa() {}
  
  public String getAlternativa() { return alternativa; }
  
  public void setAlternativa(String alternativa) {
    this.alternativa = alternativa;
  }
  
  public boolean getCorreta() {
    return correta;
  }
  
  public void setCorreta(boolean correta) { this.correta = correta; }
  

  public void inserir(String texto, boolean correta)
  {
    alternativa = texto;
    this.correta = correta;
  }
  
  public void alterar(String texto) {
    alternativa = texto;
  }
}