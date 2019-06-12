package gerador_provas.control;

import static com.oracle.webservices.internal.api.databinding.DatabindingModeFeature.ID;
import gerador_provas.dao.AlternativaDAO;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Questao;
import java.sql.Blob;

public class AlternativaController {

    public static void deletar(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
        public void atualizar(Alternativa alternativa){
            AlternativaDAO alternativaDAO = new AlternativaDAO();    
            
            alternativaDAO.atualizar(new Alternativa(alternativa.getAlternativa(), alternativa.getImagem(), alternativa.getCorreta()));
        }
        public void deletar(Alternativa alternativa){
            AlternativaDAO alternativaDAO = new AlternativaDAO();
            
            alternativaDAO.deletar(new Alternativa(alternativa.getIdAlternativa()));
        }
}
