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
		
		
				
		
		if(op == 1) {
		
			Scanner entrada = new Scanner(System.in);
			/*System.out.println("Cadastro de professor");
			
			System.out.println("CPF: ");
			long cpf = entrada.nextLong();
		
			
			System.out.println("Nome: ");
			String nome = entrada.nextLine();
			
			System.out.println("Instituicao: ");
			String instituicao = entrada.nextLine(); 
			
			System.out.println("E-mail: ");
			String email = entrada.nextLine();
			
			System.out.println("Senha: ");
			String senha = entrada.nextLine();
			
			Professor professor = new Professor(cpf,nome,instituicao,email,senha); */
			
			Professor professor = new Professor(12457981236L, "Maria Lúcia", "Escola Estadual Francisco da Silva", "escola.lucia@gmail.com", "1234abcd");
			
			
			ProfessorController professorc = new ProfessorController();
			long professor_cpf = professorc.insere(professor);
			
			
			String enunciado = "O sonorizador é um dispositivo físico implantado sobre a superfície de uma rodovia de modo que provoque uma trepidação e ruído quando da passagem de um veículo sobre ele, alertando para uma situação atípica à frente, como obras, pedágios ou travessia de pedestres. Ao passar sobre os sonorizadores, a suspensão do veículo sofre vibrações que produzem ondas sonoras, resultando em um barulho peculiar. Considere um veículo que passe com velocidade constante igual a 108km/h sobre um sonorizador cujas faixas são separadas por uma distância de 8cm.";
			
			Origem origem = new Origem("ENEM", 2018);
			OrigemController origemc = new OrigemController();
			origem.setIdorigem(origemc.insere(origem));
			
			Area area = new Area("Ciências da Natureza e suas Tecnologias");
			AreaController areac = new AreaController();
			area.setIdarea(areac.insere(area));
			
			
			Disciplina disciplina =  new Disciplina("Física");
			DisciplinaController disciplinac = new DisciplinaController();
			disciplina.setIddisciplina(disciplinac.insere(disciplina));

			
			Alternativa[] alternativas = new Alternativa[5];
			
			Alternativa a1 = new Alternativa();
			a1.setAlternativa("8,6 hertz.");
			a1.setCorreta(false);
			
			Alternativa a2 = new Alternativa();
			a2.setAlternativa("13,5 hertz.");
			a2.setCorreta(false);
			
			Alternativa a3 = new Alternativa();
			a3.setAlternativa("375 hertz.");
			a3.setCorreta(true);
			
			Alternativa a4 = new Alternativa();
			a4.setAlternativa("1350 hertz.");
			a4.setCorreta(false);
			
			Alternativa a5 = new Alternativa();
			a5.setAlternativa("4860 hertz.");
			a5.setCorreta(false);
			
			alternativas[0] = a1;
			alternativas[1] = a2;
			alternativas[2] = a3;
			alternativas[3] = a4;
			alternativas[4] = a5;
			
			
			
			Questao questao = new Questao(professor, area, disciplina, origem, enunciado, alternativas);
			
			questaoc.insere(questao);

		}
		
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
			Questao questao = new Questao();
			
			//prova.setProfessor(professor);
			prova.setCabecalho("Fazendo um teste de cabecalho...");
			
			QuestaoDAO aquestaoDAO = new QuestaoDAO();
			
			
			ArrayList<Questao> questoes = aquestaoDAO.lista(2);
			//ArrayList<Questao> questaoInserida = new ArrayList<Questao>();
			
			prova.setProfessor(questao.getProfessor());
			
			
		     for (Questao q : questoes) {
		    	  System.out.println("\nID: " + q.getIdquestao());
		          System.out.println("Enunciado: \n"+ q.getEnunciado());
		          System.out.println("Origem: " + q.getProfessor().getNome());  
		     }
		     
		     
		     //QuestaoDAO questaoDAO = new QuestaoDAO();
		     //questaoDAO.pesquisaId(1);
		     
		     prova.adicionaQuestao(2);
		     prova.adicionaQuestao(3);
		     
		     System.out.println("\n" + prova.getQuestoes().get(0).getEnunciado());
		     System.out.println("\n" + prova.getQuestoes().get(1).getEnunciado());
	   
		}
	}

}
