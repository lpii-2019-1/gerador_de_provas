package gerador_provas.control;

import gerador_provas.dao.AlternativaDAO;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Questao;

public class AlternativaController {

	public int insere(Alternativa alternativa, Questao questao) {
		
		AlternativaDAO alternativaDAO = new AlternativaDAO();
		Alternativa resultado = alternativaDAO.pesquisar(alternativa, questao);
		
		if(resultado.getIdAlternativa() == alternativa.getIdAlternativa() && resultado.getIdQuestao() == alternativa.getIdQuestao()) {
			return resultado.getIdQuestao();
		}
		else {
			alternativaDAO.cadastrar(alternativa, questao);
			Alternativa resul = alternativaDAO.pesquisar(alternativa, questao);
			return resul.getIdQuestao();
			
		}
	}
}
