package gerador_provas.teste;


import gerador_provas.model.Questao;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Area;
import gerador_provas.model.Disciplina;
import gerador_provas.model.Origem;

public class TesteQuestao {

	public static void main(String[] args) {
		
		
		String enunciado = "Esse é um texto de teste. Estamos tentando criar uma questão, esse será o enunciado";
		Origem origem = new Origem("ENEM", 2018);
		Area area = new Area();
		area.setArea("Testando");
		Disciplina disciplina =  new Disciplina("Teste");
		Alternativa[] alternativas = new Alternativa[5];
		
		Alternativa a1 = new Alternativa();
		a1.setAlternativa("Texto1");
		a1.setCorreta(false);
		
		Alternativa a2 = new Alternativa();
		a2.setAlternativa("Texto2");
		a2.setCorreta(false);
		
		Alternativa a3 = new Alternativa();
		a3.setAlternativa("Texto3");
		a3.setCorreta(true);
		
		Alternativa a4 = new Alternativa();
		a4.setAlternativa("Texto4");
		a4.setCorreta(false);
		
		Alternativa a5 = new Alternativa();
		a5.setAlternativa("Texto5");
		a5.setCorreta(false);
		
		alternativas[0] = a1;
		alternativas[1] = a2;
		alternativas[2] = a3;
		alternativas[3] = a4;
		alternativas[4] = a5;
		
		//alternativa[0].setAlternativa("Alternativa 1");
		//alternativa[0].setCorreta(false);
		//alternativa[1].setAlternativa("Alternativa 2");
		//alternativa[1].setCorreta(true);
		
		
		
		Questao q1 = new Questao(enunciado, alternativas, origem, area, disciplina);
		//System.out.println(q1.getAlternativa().toString());
		Alternativa[] alt = q1.getAlternativa();
		//System.out.println(alt[2].getAlternativa());
		//System.out.println(alt[2].getCorreta());
		
		System.out.println("Origem " + q1.getOrigem().getOrigem() + "" + q1.getOrigem().getAno());
		System.out.println("Enunciado: \n" + q1.getEnunciado());
		for(int i=0; i<5;i++) {
			System.out.println(alt[i].getAlternativa());
		}
		
		System.out.println("Area: " + q1.getArea().getArea());
		System.out.println("Disiciplina: " + q1.getDisciplina().getDisciplina());
		

	}

}
