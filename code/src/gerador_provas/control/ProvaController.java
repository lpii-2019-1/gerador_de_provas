package gerador_provas.control;

import gerador_provas.dao.AlternativaDAO;
import gerador_provas.dao.ProvaDAO;
import gerador_provas.dao.TipoDAO;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Prova;
import gerador_provas.model.Tipo;

import java.util.ArrayList;
import java.util.Random;

public class ProvaController {

	ProvaDAO provaDAO = new ProvaDAO();
	TipoDAO tipoDAO = new TipoDAO();
	Tipo tipo = new Tipo();
	
	public int insere(Prova prova) {
		Prova provaResul = provaDAO.cadastrar(prova);
		AlternativaDAO alternativaDAO = new AlternativaDAO();
	
		Random aleatorio = new Random();
		
		String letras = "ABCDE";
		String armazenaChaves = "";
		int index = -1;
		int cont = 0;
		
		for(int x = 0; x <= prova.getTipos(); x++) {
			cont ++;
			tipo.setProva(provaResul);
			tipo.setIdtipo(cont);
			
			for(int i=0; i <= provaResul.getQuestoes().length; i++) {
				tipo.setQuestoes(provaResul.getQuestoes());
				tipo.setPosicao(aleatorio.nextInt((provaResul.getQuestoes().length)) + 1);
		
				ArrayList<Alternativa> lista = new ArrayList<Alternativa>();
				
				System.out.println(prova.getQuestoes()[i].getIdquestao());
				
				
				lista.addAll(alternativaDAO.listar(prova.getQuestoes()[i]));		
				System.out.println(lista);
				
				for(int w = 1; w<= 6; w++) {
					tipo.setAlternativas(alternativaDAO.listar(prova.getQuestoes()[w]));
				}
			}
			
			
			
			
			
			index = aleatorio.nextInt(letras.length());
			armazenaChaves += letras.substring(index, index +1);
			
			tipo.setLetra(armazenaChaves);
		}
		
		
		
		return 0;
	}
}
