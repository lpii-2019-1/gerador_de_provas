package gerador_provas.teste;

import gerador_provas.control.DisciplinaController;
import gerador_provas.model.Disciplina;

public class TesteDisciplina {
	public static void main(String[] args) {
		
		DisciplinaController disciplinac = new DisciplinaController();
		Disciplina disciplina = new Disciplina("Português");
		
		
		int resultado = disciplinac.insere(disciplina);
		System.out.println(resultado);
		
	
		
	}
	
}
