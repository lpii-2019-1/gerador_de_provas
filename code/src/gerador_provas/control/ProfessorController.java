package gerador_provas.control;

import gerador_provas.dao.ProfessorDAO;
import gerador_provas.model.Professor;

public class ProfessorController {
	
	public long insere(Professor professor) {
		ProfessorDAO professorDAO = new ProfessorDAO();
		Professor resultado = professorDAO.pesquisar(professor); 
		
		if(resultado.getCpf() == professor.getCpf()) {
			return resultado.getCpf();
		}
		else {
			professorDAO.cadastrar(professor);
			Professor resul = professorDAO.pesquisar(professor);
			return resul.getCpf();
		}
	}
}
