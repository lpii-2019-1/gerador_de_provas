package gerador_provas.teste;


import gerador_provas.model.Area;
import gerador_provas.model.Questao;
import model.Aluno;

import java.util.ArrayList;
import java.util.Scanner;

import gerador_provas.control.AreaController;
import gerador_provas.control.DisciplinaController;
import gerador_provas.control.OrigemController;
import gerador_provas.control.ProfessorController;
import gerador_provas.control.ProvaController;
import gerador_provas.control.QuestaoController;
import gerador_provas.dao.AlternativaDAO;
import gerador_provas.dao.AreaDAO;
import gerador_provas.dao.QuestaoDAO;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Disciplina;
import gerador_provas.model.Origem;
import gerador_provas.model.Professor;
import gerador_provas.model.Prova;

public class TesteQuestao {

	public static void main(String[] args) {
		
		QuestaoController questaoc = new QuestaoController();
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("1 - Cadastrar Questao  \n2 - Atualizar \n3 - Gerar Prova");
		int op = input.nextInt();
		
		
		// Apagar
		 
		 

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
		origem.setIdorigem(origemc.insere(origem));
		
		Area area = new Area("Linguagens, Códigos e suas Tecnologias");
		AreaController areac = new AreaController();
		area.setIdarea(areac.insere(area));
		
		
		Disciplina disciplina =  new Disciplina("Português");
		DisciplinaController disciplinac = new DisciplinaController();
		disciplina.setIddisciplina(disciplinac.insere(disciplina));

		
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
		
		
		
		Questao questao = new Questao(professor, area, disciplina, origem, enunciado, alternativas);
		
		questaoc.insere(questao);

		

		 
		 
		 
		 //Apagar  
		
		
		
		
		
		/*if(op == 1) {
		
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
			origem.setIdorigem(origemc.insere(origem));
			
			Area area = new Area("Linguagens, Códigos e suas Tecnologias");
			AreaController areac = new AreaController();
			area.setIdarea(areac.insere(area));
			
			
			Disciplina disciplina =  new Disciplina("Português");
			DisciplinaController disciplinac = new DisciplinaController();
			disciplina.setIddisciplina(disciplinac.insere(disciplina));

			
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
			
			
			
			Questao questao = new Questao(professor, area, disciplina, origem, enunciado, alternativas);
			
			questaoc.insere(questao);

			
			
			
		} */
		
		if(op == 2) {

			// Arrumando atualização do questao.
			Questao questaoAtualizar = new Questao();
			
			questaoAtualizar.setEnunciado("Para serem absorvidos pelas células do intestino, os lipídios ingeridos precisam ser primeiramente emulsificados. Nessa etapa da digestão, torna-se necessária a ação dos ácidos biliares, visto que os lipídios apresentam uma natureza apolar e são insolúveis em água.\n" + 
					"\n" + 
					"Esses ácidos atuam no processo de modo a");
			
			
			QuestaoDAO questaoDAO = new QuestaoDAO();
			Questao questaoAtualizada = questaoDAO.pesquisar(questaoAtualizar);
			
			
			Area novaArea = new Area();
			questaoAtualizada.setArea(novaArea);
			
			Disciplina novaDisciplina = new Disciplina();
			questaoAtualizada.setDisciplina(novaDisciplina);
			
			Origem novaOrigem = new Origem(1);
			questaoAtualizada.setOrigem(novaOrigem);
			
			
			questaoc.atualiza(questaoAtualizada);
			
			//questaoDAO.pesquisar(questaoAtualizar);			
		}
		
		else if(op == 3) {
			Prova prova = new Prova();
				
			//prova.setProfessor(professor);
			prova.setCabecalho("Fazendo um teste de cabecalho...");
			
			QuestaoDAO aquestaoDAO = new QuestaoDAO();
			
			ArrayList<Questao> questoes = aquestaoDAO.lista(1);
			//ArrayList<Questao> questaoInserida = new ArrayList<Questao>();
			
			prova.setProfessor(questao.getProfessor());
			
			
		     /*for (Questao q : questoes) {
		    	  System.out.println("\nID: " + q.getIdquestao());
		          System.out.println("Enunciado: \n"+ q.getEnunciado());
		          System.out.println("Origem: " + q.getProfessor().getNome());  
		     }*/
		     
		     
		     QuestaoDAO questaoDAO = new QuestaoDAO();
		     //questaoDAO.pesquisaId(1);
		     
		     prova.adicionaQuestao(1);
		     
		     System.out.println(prova.getQuestoes());
	
		  
		     // pesquisar questao pelo id;
		     // Fazer metodo em prova para inserir questao;
		     
		}
	}

}
