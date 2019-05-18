package gerador_provas.teste;
import gerador_provas.model.Professor;
import gerador_provas.control.ProfessorController;

public class TesteProfessor {

	public static void main(String[] args) {
		
		Professor professor = new Professor(5235087130L, "Francisco Santos", "UEG", "mirelleamaral@ifgoiano.edu.br", "ABC123");
		ProfessorController professorc = new ProfessorController();
		long resultado = professorc.insere(professor);
		
	
		System.out.println(resultado + "\nFim da execução");
	}

}
