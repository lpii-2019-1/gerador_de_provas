package gerador_provas.model;

public class Alternativa {
  private int idAlternativa;
  private String alternativa;
  private boolean correta;
  private String imagem;
  
  public Alternativa() {
	  
  }
  
  public int getIdAlternativa() { return idAlternativa; }

  public void setIdAlternativa(int idAlternativa) { this.idAlternativa = idAlternativa; }
  
  public String getAlternativa() { return alternativa; }
  
  public void setAlternativa(String alternativa) { this.alternativa = alternativa; }
  
  public boolean getCorreta() { return correta; }
  
  public void setCorreta(boolean correta) { this.correta = correta; }
  
  public String getImagem() {return imagem; }

  public void setImagem(String imagem) { this.imagem = imagem; }

  
  public void inserir(String texto, boolean correta, String imagem)
  {
    this.alternativa = texto;
    this.correta = correta;
    this.imagem = imagem;
  }
  
  public void alterar(String texto) {
    this.alternativa = texto;
  }




}