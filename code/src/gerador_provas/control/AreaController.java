package gerador_provas.control;

import gerador_provas.dao.AreaDAO;
import gerador_provas.model.Area;

public class AreaController {
	
	public int insere(Area area) {
		AreaDAO areaDAO = new AreaDAO();
		Area resultado = areaDAO.pesquisar(area);
		
		if(resultado.getArea().equals(area.getArea()) ) {
			return resultado.getIdarea();
		}
		else {
			areaDAO.cadastrar(area);
			Area resul = areaDAO.pesquisar(area);
			return resul.getIdarea();
		}
	}
}
