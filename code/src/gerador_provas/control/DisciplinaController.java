package gerador_provas.control;


import gerador_provas.dao.DisciplinaDAO;
import gerador_provas.model.Disciplina;
import gerador_provas.model.Questao;

public class DisciplinaController {
	
	public int insere(Disciplina disciplina) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Disciplina resultado = disciplinaDAO.pesquisar(disciplina);
		
		if(resultado.getDisciplina() != null) {
			if(resultado.getDisciplina().equals(disciplina.getDisciplina())) {
				return resultado.getIddisciplina();
			}
			return resultado.getIddisciplina();
		}
		
		else {
			disciplinaDAO.cadastrar(disciplina);
			return disciplina.getIddisciplina();
		}
                
	}	
        
        public void atualizar(int ID, Disciplina disciplina){
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();    
            disciplina.setIddisciplina(ID);
            disciplinaDAO.atualizar(disciplina);
        }
        public void deletar(int ID){
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();    
            Disciplina oDisciplina = new Disciplina();
            oDisciplina.setIddisciplina(ID);
            disciplinaDAO.deletar(oDisciplina);
        }
   
	
}
