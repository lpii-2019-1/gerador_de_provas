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
	public void atualizar(Professor professor){
		ProfessorDAO professorDAO = new ProfessorDAO();    
		
		professorDAO.atualizar(new Professor(professor.getCpf(), professor.getNome(), professor.getInstituicao(), professor.getEmail(), professor.getSenha()));
	}
	public void deletar(Professor professor){
		ProfessorDAO professorDAO = new ProfessorDAO();
		
		professorDAO.deletar(new Professor(professor.getCpf()));
	}
}
