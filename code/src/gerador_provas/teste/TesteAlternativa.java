package gerador_provas.teste;

import gerador_provas.control.AlternativaController;
import gerador_provas.dao.AlternativaDAO;
import gerador_provas.model.Alternativa;

public class TesteAlternativa {
  
  public static void main(String[] args) { 
	 
	  Alternativa[] alternativas = new Alternativa[5];
		
		Alternativa a1 = new Alternativa();
		a1.setAlternativa("procura entender o próximo, assumindo atitudes positivas como simpatia, empatia, "
				+ "honestidade, compaixão, confiança e solidariedade, o que caracteriza o valor da igualdade. ");
		a1.setCorreta(false);
		
		Alternativa a2 = new Alternativa();
		a2.setAlternativa("Faz com que todos possam ser iguais e receber o mesmo tratamento, assegurando imparcialidade, "
				+ "oportunidades e tratamentos iguais a todos, o que caracteriza o valor da amizade.");
		a2.setCorreta(false);
		
		Alternativa a3 = new Alternativa();
		a3.setAlternativa("Dá o melhor de si na vivência das diversas atividades relacionadas ao esporte ou aos jogos, "
				+ "participando e progredindo de acordo com seus objetivos, o que caracteriza o valor da coragem. ");
		a3.setCorreta(false);
		
		Alternativa a4 = new Alternativa();
		a4.setAlternativa("Manifesta a habilidade de enfrentar a dor, o sofrimento, o medo, a incerteza e a intimidação nas atividades,"
				+ " agindo corretamente contra a vergonha, a desonra e o desânimo, o que caracteriza o valor da determinação. ");
		a4.setCorreta(false);
		
		Alternativa a5 = new Alternativa();
		a5.setAlternativa("Manifesta a habilidade de enfrentar a dor, o sofrimento, o medo, a incerteza e a intimidação nas atividades, "
				+ "agindo corretamente contra a vergonha, a desonra e o desânimo, o que caracteriza o valor da determinação. ");
		a5.setCorreta(true);
		
		alternativas[0] = a1;
		alternativas[1] = a2;
		alternativas[2] = a3;
		alternativas[3] = a4;
		alternativas[4] = a5;
		
   
    
		AlternativaDAO alternativaDAO = new AlternativaDAO();
		alternativaDAO.cadastrar(alternativas, questao);
		
    
    
  }
}