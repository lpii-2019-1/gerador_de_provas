package gerador_provas.control;



import gerador_provas.model.Professor;
import gerador_provas.model.Questao;
import gerador_provas.dao.QuestaoDAO;
import gerador_provas.model.Area;
import gerador_provas.model.Disciplina;
import gerador_provas.control.AlternativaController;


public class QuestaoController {

	public int insere(Questao questao) {
		QuestaoDAO questaoDAO = new QuestaoDAO();
		
		ProfessorController professorc = new ProfessorController();
		Long idprofessor = professorc.insere(questao.getProfessor());
		
		AreaController areac= new AreaController();
		int idarea = areac.insere(questao.getArea());
		
		DisciplinaController disciplinac = new DisciplinaController();
		int iddisciplina = disciplinac.insere(questao.getDisciplina());
		
		OrigemController origemc = new OrigemController();
		int idorigem = origemc.insere(questao.getOrigem());
		
		AlternativaController alternativac = new AlternativaController();
		int idalternativa = alternativac.insere(questao.getAlternativas());
		
		Questao resultado = questaoDAO.pesquisar(questao);
		
		if(resultado.getEnunciado().equals(questao.getEnunciado())) {
			return resultado.getIdquestao();
		}
		else {
			questaoDAO.cadastrar(questao);
			Questao resul = questaoDAO.pesquisar(questao);
			return resul.getIdquestao();
		}
		
		return 0;
		
	}
}
