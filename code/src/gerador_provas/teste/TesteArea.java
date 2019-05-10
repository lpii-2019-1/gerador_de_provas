package gerador_provas.teste;

import gerador_provas.dao.AreaDAO;
import gerador_provas.model.Area;

public class TesteArea {

	public static void main(String[] args) {
		
		AreaDAO areaDAO = new AreaDAO(); 
		
		//Area a1 = new Area();
		//a1.setArea("Matemática e suas Tecnologias");
		
		//areaDAO.cadastrar(a1);
		
		
		
		Area areaPesquisada = areaDAO.pesquisar("Linguagens");
        
        if (areaPesquisada.getIdarea() != 0) {
            System.out.println(areaPesquisada.getIdarea());
            System.out.println(areaPesquisada.getArea());
        }
        else {
        	System.out.println("Não encontrado");
        }
		
	}

}
