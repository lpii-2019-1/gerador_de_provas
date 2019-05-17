package gerador_provas.control;

import gerador_provas.dao.OrigemDAO;
import gerador_provas.model.Origem;

public class OrigemController {
	
	public String insere(Origem origem) {
		OrigemDAO origemDAO = new OrigemDAO();
		Origem resultado = origemDAO.pesquisar(origem);
		
		if(resultado.getOrigem() != origem.getOrigem() && resultado.getAno() != origem.getAno() ) {
			origemDAO.cadastrar(origem);
			return "Inserido com sucesso";
		}
		else {
			return "A origem já está inserida.";
		}
	}
}
