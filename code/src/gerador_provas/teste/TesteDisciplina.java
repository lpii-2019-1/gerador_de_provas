package gerador_provas.teste;

import gerador_provas.control.DisciplinaController;
import gerador_provas.model.Disciplina;

public class TesteDisciplina {


	public static void main(String[] args) {
		
		DisciplinaController disciplinac = new DisciplinaController();
		Disciplina disciplina = new Disciplina("Português");// busca ela pelo nome
		
			
		int resultado = disciplinac.insere(disciplina); // pega o id
		System.out.println(resultado);
                //disciplinac.deletar(resultado);
                //disciplinac.atualizar(resultado, new Disciplina("Português")); // passo o id com o novo nome ou as novas informacoes
		//
	 

		
	}
	
}
