package gerador_provas.teste;
import java.util.Scanner;

import gerador_provas.control.OrigemController;
import gerador_provas.dao.OrigemDAO;
import gerador_provas.model.Origem;

public class TesteOrigem {
	
	public static void main(String[] args) {
		OrigemController origemc = new OrigemController();
		OrigemDAO origemDAO = new OrigemDAO();
		
		Scanner input = new Scanner(System.in);
		String origemTexto;
		int origemAno;
		
		System.out.print("Insira uma nova oridem: ");
		origemTexto = input.nextLine();
		System.out.print("Inseira o ano: ");
		origemAno = input.nextInt();
		
		Origem origem = new Origem(origemTexto, origemAno);
		
		int resultado = origemc.insere(origem);
		System.out.println(resultado);
		
		//Origem resultado = origemDAO.pesquisar(origem);
		//System.out.println(resultado.getIdorigem() + " " + resultado.getOrigem() + " " + resultado.getAno());
		
		//System.out.println(origem.getOrigem() + " " + origem.getAno() );
		
	}
}
