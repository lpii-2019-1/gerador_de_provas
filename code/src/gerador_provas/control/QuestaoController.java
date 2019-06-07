package gerador_provas.control;


import gerador_provas.model.Questao;
import gerador_provas.dao.QuestaoDAO;


public class QuestaoController {

	QuestaoDAO questaoDAO = new QuestaoDAO();
	
	public int insere(Questao questao) {
		
		Questao resultado = questaoDAO.pesquisar(questao);
		
		// Verfica se a questao existe (questao != null)
		// Sabendo que existe uma questao, verifica se ela já está no banco.
		if(resultado.getEnunciado() != null) {
			if(resultado.getEnunciado().equals(questao.getEnunciado())) {
				return resultado.getIdquestao();
			}
		 return resultado.getIdquestao();
		}
		else {
			questaoDAO.cadastrar(questao);
			Questao resul = questaoDAO.pesquisar(questao);
			return resul.getIdquestao();
		}
		
	}
	
	public void atualiza(Questao questao) {
		Questao resultado = questaoDAO.pesquisar(questao);
		Questao questaoAtualizar = new Questao();
		
		if(resultado.getEnunciado() != null) {
			
			if(questao.getArea().getIdarea() == 0) {questaoAtualizar.setArea(resultado.getArea()); }
			else {questaoAtualizar.setArea(questao.getArea());}
			
			if(questao.getDisciplina().getIddisciplina() == 0) {questaoAtualizar.setDisciplina(resultado.getDisciplina());}
			else {questaoAtualizar.setDisciplina(questao.getDisciplina());}
			
			if(questao.getOrigem().getIdorigem() == 0) {questaoAtualizar.setOrigem(resultado.getOrigem());}
			else {questaoAtualizar.setOrigem(questao.getOrigem());}
			
			if(questao.getImagem() == null) {questaoAtualizar.SetImagem(resultado.getImagem());}
			else {questaoAtualizar.SetImagem(questao.getImagem());}
			
			questaoAtualizar.setProfessor(resultado.getProfessor());
			questaoAtualizar.setEnunciado(questao.getEnunciado());
			
			questaoDAO.atualizar(questaoAtualizar);
		}
		else {
			System.out.println("Erro, questão invalida");
		}
		
	}
}
