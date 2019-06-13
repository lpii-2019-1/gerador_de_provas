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
			
		return 0;
	}
}
