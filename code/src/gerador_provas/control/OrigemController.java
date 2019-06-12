package gerador_provas.control;

import gerador_provas.dao.OrigemDAO;
import gerador_provas.model.Origem;

public class OrigemController {
	
	public int insere(Origem origem) {
		OrigemDAO origemDAO = new OrigemDAO();
		Origem resultado = origemDAO.pesquisar(origem);
		
		if(resultado.getOrigem() != null) {
			if(resultado.getOrigem().equals(origem.getOrigem()) && resultado.getAno() == origem.getAno() ) {
				return resultado.getIdorigem();
			}
			return resultado.getIdorigem();
		}
		
		else {
			origemDAO.cadastrar(origem);
			return origem.getIdorigem();
		}
                
	}
        public void atualizar(Origem origem){
            OrigemDAO origemDAO = new OrigemDAO();    
            
            origemDAO.atualizar(new Origem(origem.getIdorigem(), origem.getOrigem(), origem.getAno()));
        }
        public void deletar(Origem origem){
            OrigemDAO origemDAO = new OrigemDAO();
            
            origemDAO.deletar(new Origem(origem.getIdorigem()));
        }
}
