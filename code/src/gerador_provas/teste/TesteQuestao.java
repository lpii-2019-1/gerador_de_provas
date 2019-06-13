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
import gerador_provas.dao.AreaDAO;
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
		
		System.out.println("1 - Cadastrar Professor  \n2 - Login");
		String wv = input.nextLine();
		int op = Integer.parseInt(wv);
		
				
		
		if(op == 1) {
			
			Scanner entrada = new Scanner(System.in);
			System.out.println("Cadastro de professor");
			
			System.out.println("CPF: ");
			String cpf2 = entrada.nextLine();
			long cpf = Long.parseLong(cpf2);
			
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
			
			ProfessorController professorc = new ProfessorController();
			long professor_cpf = professorc.insere(professor);
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
				
				System.out.println("MENU\n1 - Cadastrar Questoes      \n2- Deletar Questoes  \n3 - Gerar Provas \n0 - Sair");
				
				int operacao = entrada.nextInt();
				while(operacao != 0) {
					
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
						a5.setCorreta(false);
						
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
						operacao = opcao;
					}
					else if(operacao == 2) {
						
						System.out.println("================ Deletar Questao ================");
						
						QuestaoDAO aquestaoDAO = new QuestaoDAO();
						ArrayList<Questao> questoes = aquestaoDAO.lista();
						
					     for (Questao q : questoes) {
					    	  System.out.println("\nID: " + q.getIdquestao());
					          System.out.println("Enunciado: \n"+ q.getEnunciado());
					          System.out.println("Area: " + q.getArea().getArea());
					          System.out.println("Disciplina: " + q.getDisciplina().getDisciplina());
					          System.out.println("Origem: " + q.getProfessor().getNome());  
					     }
					     
					     System.out.print("\nID: ");
					     Scanner pqp  = new Scanner(System.in);
					     
					     String kkk = pqp.nextLine();
					     int iddelete = Integer.parseInt(kkk);
					     
					     
					     System.out.println(questaoc.deletar(iddelete));
					     
					 	System.out.println("\nMENU\n1 - Cadastrar Questoes      \n2 - Deletar Questoes   \n3 - Gerar Provas \n0 - Sair");
					    int opcao = entrada.nextInt();
						operacao = opcao;
						
					}
					else if(operacao == 3) {
						
						Prova prova = new Prova();
						Questao questao = new Questao();
						ProvaController provac = new ProvaController();
						
						String cabecalho = entrada.nextLine();
						
						prova.setCabecalho(cabecalho);
						
						QuestaoDAO aquestaoDAO = new QuestaoDAO();
						
						
						ArrayList<Questao> questoes = aquestaoDAO.lista();
						prova.setProfessor(professor);
						
						
					     for (Questao q : questoes) {
					    	  System.out.println("\nID: " + q.getIdquestao());
					          System.out.println("Enunciado: \n"+ q.getEnunciado());
					          System.out.println("Area: " + q.getArea().getArea());
					          System.out.println("Disciplina: " + q.getDisciplina().getDisciplina());
					          System.out.println("Origem: " + q.getProfessor().getNome());  
					     }
					     
					     
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
					    
						System.out.println("\nMENU\n1 - Cadastrar Questoes      \n2 - Deletar Questoes   \n3 - Gerar Provas \n0 - Sair");
					    int opcao = entrada.nextInt();
						operacao = opcao;
						
					}
					
				}
				
				
			}
			
			else {
				System.out.println("Login invalido");
			}
		}
				
	}

}
