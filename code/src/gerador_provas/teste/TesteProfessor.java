package gerador_provas.teste;
import gerador_provas.model.Professor;
import gerador_provas.control.ProfessorController;

public class TesteProfessor {

	public static void main(String[] args) {
		
		Professor professor = new Professor(5235087130L, "Francisco Santos", "UEG", "mirelleamaral@ifgoiano.edu.br", "ABC123");
		ProfessorController professorc = new ProfessorController();
		long resultado = professorc.insere(professor);
		
	
		System.out.println(resultado + "\nFim da execução");



		long cpf = 500508713;
		String nome = "Bruno Geovane";
		String instituicao = "if goiano";
		String email = "bruno@gmail";
		String senha = "testsenha";
		
		professorc.atualizar(new Professor(cpf, nome, instituicao, email, senha));
	  //  professorc.deletar(new Professor(cpf));
}
	}


