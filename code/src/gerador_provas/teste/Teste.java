package gerador_provas;


public class Teste {
  
  public static void main(String[] args) { 
	 
	Alternativa a = new Alternativa();
    
    a.inserir("2+3", false);
    
    System.out.println(a.getAlternativa() + a.getCorreta());
  }
}