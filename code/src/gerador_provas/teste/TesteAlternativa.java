package gerador_provas.teste;

import gerador_provas.model.Alternativa;

public class TesteAlternativa {
  
  public static void main(String[] args) { 
	 
	Alternativa a = new Alternativa();
    
    a.inserir("A tecnologia de comunicação da etiqueta RFID (chamada de etiqueta inteligente) é usada há anos para rastrear gado, vagões de trem, bagagem aérea e carros nos pedágios. Um modelo mais barato dessas etiquetas pode funcionar sem baterias e é constituído por três componentes: um microprocessador de silício; uma bobina de metal, feita de cobre ou alumínio, que é enrolada em um padrão circular; e um encapsulador, que é um material de vidro ou polímero envolvendo o microprocessador e a bobina. Na presença de um campo de radiofrequência gerado pelo leitor, a etiqueta transmite sinais. A distância de leitura é determinada pelo tamanho da bobina e pela potência da onda de rádio emitida pelo leitor.\n" + 
    		"\n" + 
    		"", true, null);
    
    System.out.println(a.getAlternativa() + a.getCorreta());
  }
}