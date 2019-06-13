package gerador_provas.control;

import gerador_provas.dao.AlternativaDAO;
import gerador_provas.dao.ProvaDAO;
import gerador_provas.dao.TipoDAO;
import gerador_provas.model.Alternativa;
import gerador_provas.model.Prova;
import gerador_provas.model.Tipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.midi.Soundbank;

public class ProvaController {

	ProvaDAO provaDAO = new ProvaDAO();
	TipoDAO tipoDAO = new TipoDAO();
	Tipo tipo = new Tipo();
	
	public int insere(Prova prova) {
		Prova provaResul = provaDAO.cadastrar(prova);
		
		System.out.println(provaResul.getCabecalho());
		System.out.println(provaResul.getIdprova());
		System.out.println(provaResul.getProfessor().getNome());
		System.out.println(provaResul.getQuestoes().get(0).getEnunciado());
		System.out.println(provaResul.getQuestoes().get(1).getEnunciado());
		int tamanho = provaResul.getQuestoes().size();
		
		tipo.setProva(provaResul);
		tipo.setIdtipo(1);
		tipo.setLetra("A");
		for(int i=0; i< tamanho; i++) {
			tipo.setPosicao(i);
			tipo.adicionaQuestao(provaResul.getQuestoes().get(i).getIdquestao());
			tipoDAO.cadastrar(tipo, provaResul);
		}
		
		
		
		
		
		
		
		return 0;
	}
}
