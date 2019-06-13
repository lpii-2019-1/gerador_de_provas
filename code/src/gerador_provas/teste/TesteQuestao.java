package gerador_provas.teste;


import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

import gerador_provas.control.AreaController;
import gerador_provas.control.DisciplinaController;
import gerador_provas.control.OrigemController;
import gerador_provas.control.ProfessorController;
import gerador_provas.control.ProvaController;
import gerador_provas.control.QuestaoController;
import gerador_provas.dao.ProfessorDAO;
import gerador_provas.dao.ProvaDAO;
import gerador_provas.dao.QuestaoDAO;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Area;
import gerador_provas.model.Disciplina;
import gerador_provas.model.Origem;
import gerador_provas.model.Professor;
import gerador_provas.model.Prova;
import gerador_provas.model.Questao;

public class TesteQuestao {

	public static void main(String[] args) {
		
		QuestaoController questaoc = new QuestaoController();
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("1 - Cadastrar Professor  \n2 - Login \n3 - Gerar Prova");
		String wv = input.nextLine();
		int op = Integer.parseInt(wv);
		
				
		
		if(op == 1) {
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Cadastro de professor");
			
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
			
			Professor professor = new Professor(cpf,nome,instituicao,email,senha); 
			
			System.out.println(cpf);
			System.out.println(nome);
			System.out.println(instituicao);
			System.out.println(email);
			System.out.println(senha);
			
			//Professor professor = new Professor(12457981236L, "Maria Lúcia", "Escola Estadual Francisco da Silva", "escola.lucia@gmail.com", "1234abcd");
			
			
			ProfessorController professorc = new ProfessorController();
			long professor_cpf = professorc.insere(professor);
			
			
			String enunciado = "O sonorizador é um dispositivo físico implantado sobre a superfície de uma rodovia de modo que provoque uma trepidação e ruído quando da passagem de um veículo sobre ele, alertando para uma situação atípica à frente, como obras, pedágios ou travessia de pedestres. Ao passar sobre os sonorizadores, a suspensão do veículo sofre vibrações que produzem ondas sonoras, resultando em um barulho peculiar. Considere um veículo que passe com velocidade constante igual a 108km/h sobre um sonorizador cujas faixas são separadas por uma distância de 8cm.";
			
			Origem origem = new Origem("ENEM", 2018);
			OrigemController origemc = new OrigemController();
			origem.setIdorigem(origemc.insere(origem));
			
			Area area = new Area("Ciências da Natureza e suas Tecnologias");
			AreaController areac = new AreaController();
			area.setIdarea(areac.insere(area));
			
			// Tô aqui Ô!!!
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
			
			//Questao questao = new Questao(professor, area, disciplina, origem, enunciado, alternativas);
			
			//questaoc.insere(questao);

		}
		
		
		else if(op == 2) {
			Scanner entrada = new Scanner(System.in);
			
			System.out.print("CPF: ");
			long cpf = entrada.nextLong();
			System.out.print("Senha: ");
			String senha = entrada.next();
			
			ProfessorDAO professorDAO = new ProfessorDAO();
			Professor professor = new Professor();
			
			professor = professorDAO.pesquisarCpf(cpf);
			if(professor.getCpf() == cpf && professor.getSenha().equals(senha)) {
				System.out.println("\n Bem-vinda(o) " + professor.getNome() + "\n");
				
				System.out.println("MENU\n1 - Cadastrar Questoes      \n2 - Deletar Questoes   \n3 - Gerar Provas \n4 - Sair");
				
				int operacao = entrada.nextInt();
				while(operacao != 4) {
					
					if(operacao == 1) {
						
						Scanner entrada_dados = new Scanner(System.in);
						
						System.out.println("\n*Cadastro de questoes*\n");
						
						System.out.print("Origem: ");
						String orig = entrada_dados.nextLine();
						    
						System.out.print("Ano: ");
						String data = entrada_dados.nextLine();
						int ano = Integer.parseInt(data);
						
						System.out.print("Area: ");
						String ar = entrada_dados.nextLine();
						
						System.out.print("Disicplina: ");
						String disc = entrada_dados.nextLine();
						
						
						System.out.print("Enunciado: ");
						String enunciado = entrada_dados.nextLine();
						
						
						System.out.println("Insira agora as alternativas...");
						System.out.println("Informe por último a alternativa correta");
						
						Alternativa[] alternativas = new Alternativa[5];
						
						System.out.println("\n1º Alternativa:");
						String alter1 = entrada_dados.nextLine();
						Alternativa a1 = new Alternativa();
						a1.setAlternativa(alter1);
						a1.setCorreta(false);
						
						System.out.println("\n2º Alternativa:");
						String alter2 = entrada_dados.nextLine();
						Alternativa a2 = new Alternativa();
						a2.setAlternativa(alter2);
						a2.setCorreta(false);
						
						System.out.println("\n3º Alternativa:");
						String alter3 = entrada_dados.nextLine();
						Alternativa a3 = new Alternativa();
						a3.setAlternativa(alter3);
						a3.setCorreta(false);
						
						System.out.println("\n4º Alternativa:");
						String alter4 = entrada_dados.nextLine();
						Alternativa a4 = new Alternativa();
						a4.setAlternativa(alter4);
						a4.setCorreta(false);
						
						System.out.println("\n 5º Alternativa:");
						String alter5 = entrada_dados.nextLine();
						Alternativa a5 = new Alternativa();
						a5.setAlternativa(alter5);
						a5.setCorreta(true);
						
						alternativas[0] = a1;
						alternativas[1] = a2;
						alternativas[2] = a3;
						alternativas[3] = a4;
						alternativas[4] = a5;
						
						
						Origem origem = new Origem(orig, ano);
						OrigemController origemc = new OrigemController();
						origem.setIdorigem(origemc.insere(origem));
						
						Area area = new Area(ar);
						AreaController areac = new AreaController();
						area.setIdarea(areac.insere(area));
						
						Disciplina disciplina =  new Disciplina(disc);
						DisciplinaController disciplinac = new DisciplinaController();
						disciplina.setIddisciplina(disciplinac.insere(disciplina));
						
						
						Questao questao = new Questao();
						
						JFileChooser chooser = new JFileChooser();
						chooser.showDialog(null,"Selecionar");
						java.io.File oFile = chooser.getSelectedFile();
						if(oFile != null) {
							questao.SetImagem(oFile.getAbsolutePath());
						}
						

						questao.setAlternativa(alternativas);
						questao.setArea(area);
						questao.setDisciplina(disciplina);
						questao.setEnunciado(enunciado);
						questao.setOrigem(origem);
						questao.setProfessor(professor);
						questaoc.insere(questao);

						questaoc.insere(questao);
						
						int opcao = entrada.nextInt();
						//int opcao = Integer.parseInt(we);
						operacao = opcao;
					}
					else if(operacao == 2) {
						
						int opcao = entrada.nextInt();
						operacao = opcao;
						
					}
					else if(operacao == 3) {
						
						Prova prova = new Prova();
						Questao questao = new Questao();
						ProvaController provac = new ProvaController();
						
						prova.setCabecalho("Escola Estadual 31 de Fevereiro");
						
						QuestaoDAO aquestaoDAO = new QuestaoDAO();
						
						ArrayList<Questao> questoes = aquestaoDAO.lista(2);
						prova.setProfessor(professor);
						
						
					     for (Questao q : questoes) {
					    	  System.out.println("\nID: " + q.getIdquestao());
					          System.out.println("Enunciado: \n"+ q.getEnunciado());
					          System.out.println("Origem: " + q.getProfessor().getNome());  
					     }
					     
					     
					     //QuestaoDAO questaoDAO = new QuestaoDAO();
					     //questaoDAO.pesquisaId(1);
					     
					     System.out.println("\n==== Inserir questoes ====");
					     Scanner leitura = new Scanner(System.in);
					     String escolha = "s";
					     while(!escolha.equals("n")) {
					    	 System.out.print("ID: ");
					    	 String cod = leitura.nextLine(); 
					    	 int id = Integer.parseInt(cod);
					    	 prova.adicionaQuestao(id);
					    	 System.out.print("Inserir outra questao ? ");
					    	 escolha = leitura.nextLine();
					     }
					     
					    System.out.println("======================================================\n");
					    					   
					    ProvaDAO provaDAO = new ProvaDAO();
					    Prova provaResul = provaDAO.cadastrar(prova);

					    System.out.println(prova.gerarPDF(provaResul));
					    
						int opcao = entrada.nextInt();
						operacao = opcao;
						
					}
					
				}
				
				
			}
			
			else {
				System.out.println("Login invalido");
			}
		}
		
		if(op == 5) {

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
		
		/*else if(op == 3) {
			
			Scanner entrada = new Scanner(System.in);
			
			Prova prova = new Prova();
			Questao questao = new Questao();
			ProvaController provac = new ProvaController();
			
			prova.setCabecalho("Escola Estadual 31 de Fevereiro");
			
			QuestaoDAO aquestaoDAO = new QuestaoDAO();
			
			
			ArrayList<Questao> questoes = aquestaoDAO.lista(2);
			prova.setProfessor(questao.getProfessor());
			System.out.println(questao.getProfessor());
			
			
		     for (Questao q : questoes) {
		    	  System.out.println("\nID: " + q.getIdquestao());
		          System.out.println("Enunciado: \n"+ q.getEnunciado());
		          System.out.println("Origem: " + q.getProfessor().getNome());  
		     }
		     
		     
		     //QuestaoDAO questaoDAO = new QuestaoDAO();
		     //questaoDAO.pesquisaId(1);
		     
		     System.out.println("\n==== Inserir questoes ====");
		     
		     String escolha = "s";
		     while(!escolha.equals("n")) {
		    	 System.out.print("ID: ");
		    	 String cod = entrada.nextLine(); 
		    	 int id = Integer.parseInt(cod);
		    	 prova.adicionaQuestao(id);
		    	 System.out.print("Inserir outra questao ? ");
		    	 escolha = entrada.nextLine();
		     }
		     
		     
		    
		     //System.out.println(prova.getQuestoes().size());
		     //System.out.println(prova.getQuestoes().get(0).getEnunciado());
		     //System.out.println(prova.getQuestoes().get(1).getEnunciado());
		    System.out.println("======================================================\n");
		    
		    //provac.insere(prova);
		  
		    ProvaDAO provaDAO = new ProvaDAO();
		    provaDAO.cadastrar(prova);
		   
		     
		} */
	}

}
