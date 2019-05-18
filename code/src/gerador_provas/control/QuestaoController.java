package gerador_provas.control;

import gerador_provas.dao.QuestaoDAO;
import gerador_provas.model.Questao;

public class QuestaoController {

	public int insere(Questao questao) {
		QuestaoDAO questaoDAO = new QuestaoDAO();
		Questao resultado = questaoDAO.pesquisar();
		
		
		return 0;
		
	}
}
