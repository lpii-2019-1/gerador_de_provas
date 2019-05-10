package gerador_provas.teste;



import gerador_provas.model.Questao;
import gerador_provas.model.Origem;

public class TesteQuestao {

	public static void main(String[] args) {
		
		
		String enunciado = "Esse é um texto de teste. Estamos tentando criar uma questão, esse será o enunciado";
		Origem origem = new Origem("ENEM", 2018);
		String area = "Ciências do Teste e suas tecnlogias";
		String disciplina = "Testematica";
		
		Questao q1 = new Questao(enunciado, origem, area, disciplina);
		
		System.out.println("Origem " + q1.getOrigem().getOrigem() + q1.getOrigem().getAno());
		System.out.println("Enunciado: \n" + q1.getEnunciado());
		System.out.println("Area: " + q1.getArea());
		System.out.println("Disiciplina: " + q1.getDisciplina());

	}

}
