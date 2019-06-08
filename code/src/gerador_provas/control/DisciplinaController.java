package gerador_provas.control;


import gerador_provas.dao.DisciplinaDAO;
import gerador_provas.model.Disciplina;
import gerador_provas.model.Questao;

public class DisciplinaController {
	
	public int insere(Disciplina disciplina) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Disciplina resultado = disciplinaDAO.pesquisar(disciplina);
		
		if(resultado.getDisciplina().equals(disciplina.getDisciplina())) {
			return resultado.getIddisciplina();
		}
		else {
			disciplinaDAO.cadastrar(disciplina);
			return disciplina.getIddisciplina();
		}
	}	
	
}
