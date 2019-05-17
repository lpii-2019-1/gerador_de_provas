package gerador_provas.teste;


import gerador_provas.model.Questao;
import gerador_provas.dao.QuestaoDAO;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Area;
import gerador_provas.model.Disciplina;
import gerador_provas.model.Origem;
import gerador_provas.model.Professor;

public class TesteQuestao {

	public static void main(String[] args) {
		
		
		QuestaoDAO questaoDAO = new QuestaoDAO();
		
		
		
		Professor professor = new Professor(32456789143L, "Luiz Fernando", "Colégio Rua XX", "luizfernando@gmail.com", "abcd1234");
		String enunciado = "Tanto os Jogos Olímpicos quanto os Paralímpicos são mais que uma corrida por recordes, medalhas e busca de "
				+ "excelência. Por trás deles está a filosofia do barão Pierre de Coubertin, fundados do Movimento Olímpico. "
				+ "Como educador, ele viu nos Jogos a oportunidade para que os povos desenvolvessem valores, que poderiam ser aplicados não somente ao esporte, mas à educação e à sociedade. "
				+ "Os valores olímpicos são: a amizade, a excelência e o respeito, enquanto os "
				+ "valores paralímpicos são: a determinação, a coragem, a igualdade e a inspiração. ";
		Origem origem = new Origem("ENEM", 2018);
		Area area = new Area();
		area.setArea("Linguagens, Códigos e suas Tecnologias");
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
		
		
		
		Questao q1 = new Questao(professor, enunciado, alternativas, origem, area, disciplina);
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
		System.out.println("Professor: " + q1.getProfessor().getNome());

	}

}
