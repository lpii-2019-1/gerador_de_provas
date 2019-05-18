package gerador_provas.control;


import gerador_provas.dao.DisciplinaDAO;
import gerador_provas.model.Disciplina;

public class DisciplinaController {
	
	public int insere(Disciplina disciplina) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Disciplina resultado = disciplinaDAO.pesquisar(disciplina);
		
		
		// Verifica se a disciplina já foi inserida
		// 		-> Se inserida retorna o id;
		//		-> Se não inserida retorna o id após inserir.
		
		if(resultado.getDisciplina() != disciplina.getDisciplina()) {
			disciplinaDAO.cadastrar(disciplina);
			Disciplina resul = disciplinaDAO.pesquisar(disciplina);
			return resul.getIddisciplina();
			
		}
		return resultado.getIddisciplina();
		
	}
}
