package gerador_provas.model;

import java.sql.Blob;

public class Alternativa {
  private int idQuestao;
  private int idAlternativa;
  private String alternativa;
  private boolean correta;
  private Blob imagem;
  
  public Alternativa(){
  }

    public Alternativa(String alternativa, Blob imagem, boolean correta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Alternativa(int idAlternativa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Alternativa(int Id, String alternativa, Blob imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  
  public int getIdQuestao() { return idQuestao; }

  public void setIdQuestao(int idQuestao) { this.idQuestao = idQuestao; }
  
  public int getIdAlternativa() { return idAlternativa; }

  public void setIdAlternativa(int idAlternativa) { this.idAlternativa = idAlternativa; }
  
  public String getAlternativa() { return alternativa; }
  
  public void setAlternativa(String alternativa) { this.alternativa = alternativa; }
  
  public boolean getCorreta() { return correta; }
  
  public void setCorreta(boolean correta) { this.correta = correta; }
  
  public Blob getImagem() { return imagem; }
  
  public void setImagem(Blob imagem) { this.imagem = imagem; }

}