package gerador_provas.teste;


import gerador_provas.model.Area;
import gerador_provas.model.Questao;
import gerador_provas.control.AreaController;
import gerador_provas.control.DisciplinaController;
import gerador_provas.control.OrigemController;
import gerador_provas.control.ProfessorController;
import gerador_provas.dao.QuestaoDAO;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Disciplina;
import gerador_provas.model.Origem;
import gerador_provas.model.Professor;

public class TesteQuestao {

	public static void main(String[] args) {
		
		
		Professor professor = new Professor(32456789143L, "Luiz Fernando", "Colégio Rua XX", "luizfernando@gmail.com", "abcd1234");
		
		ProfessorController professorc = new ProfessorController();
		long professor_cpf = professorc.insere(professor);
		
		
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
		origem.setIdorigem(idorigem);
		
		Area area = new Area("Linguagens, Códigos e suas Tecnologias");
		AreaController areac = new AreaController();
		area.setIdarea(areac.insere(area));
		
		//area.setIdarea(idarea);
		
		
		Disciplina disciplina =  new Disciplina("Português");
		DisciplinaController disciplinac = new DisciplinaController();
		int iddisciplina = disciplinac.insere(disciplina);
		disciplina.setIddisciplina(iddisciplina);
		
		
		
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
		
		
		
		Questao questao = new Questao(professor, novaArea, novaDisciplina, novaOrigem, enunciado, alternativas);
		
		// Problema em passar e pegar o array de alternativas.
		
		System.out.println("--------------------");
		System.out.println("Professor CPF: " + questao.getProfessor().getCpf());
		System.out.println("Origem: " + questao.getOrigem().getIdorigem());
		System.out.println("Area: " + questao.getArea().getIdarea());
		System.out.println("Disiplina: " + questao.getDisciplina().getIddisciplina());
		System.out.println("Enunciado: " + questao.getEnunciado());
		System.out.println("Alternativas: \n");
		//System.out.println(questao.getAlternativa()[1]);
		System.out.println(questao.getAlternativas()[0].getAlternativa());
		
		/*for(int i=0; i<= questao.getAlternativa().length; i++) {
			System.out.println(alternativas[i]);
		}*/
		
		//Alternativa[] alt = q1.getAlternativa(); 
		
		QuestaoDAO questaoDAO = new QuestaoDAO();
		questaoDAO.cadastrar(questao);
		
		
		
	}

}
