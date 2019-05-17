package gerador_provas.teste;


import gerador_provas.model.Questao;
import gerador_provas.control.AreaController;
import gerador_provas.control.DisciplinaController;
import gerador_provas.control.OrigemController;
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
				+ "valores paralímpicos são: a determinação, a coragem, a igualdade e a inspiração."
				+ ""
				+ "No contexto das aulas de Educação Física escolar, os valores olímpicos e paralímpicos podem ser identificados quando o colega";
		
		Origem origem = new Origem("ENEM", 2018);
		OrigemController origemc = new OrigemController();
		int idorigem = origemc.insere(origem);
		
		Area area = new Area("Linguagens, Códigos e suas Tecnologias");
		AreaController areac = new AreaController();
		int idarea = areac.insere(area);
		
		
		Disciplina disciplina =  new Disciplina("Português");
		DisciplinaController disciplinac = new DisciplinaController();
		int iddisciplina = disciplinac.insere(disciplina);
		
		
		
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
		
		
		
		Questao q1 = new Questao(professor, enunciado, alternativas, origem, area, disciplina);
		
		Alternativa[] alt = q1.getAlternativa();
		
		
		System.out.println("Origem " + q1.getOrigem().getOrigem() + "" + q1.getOrigem().getAno());
		System.out.println("Enunciado: \n" + q1.getEnunciado());
		for(int i=0; i<5;i++) {
			System.out.println(alt[i].getAlternativa());
		}
	}

}
