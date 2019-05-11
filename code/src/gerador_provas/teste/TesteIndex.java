package gerador_provas.teste;
import gerador_provas.model.Professor;
import gerador_provas.dao.ProfessorDAO;

public class TesteIndex {

	public static void main(String[] args) {
		
		Professor a = new Professor();
		a.setEmail("bruno@gmail.com");
		a.setSenha("123");
		a.setCpf(56153);
		a.setNome("Bruno Geovane");

		Professor b = new Professor();
		b.setEmail("faquin@gmail.com");
		b.setSenha("123");
		b.setCpf(56667);
		b.setNome("Gustavo Faquin");

		ProfessorDAO ProfessorDAO = new ProfessorDAO();

		ProfessorDAO.inserirProfessor(a);
		ProfessorDAO.inserirProfessor(b);

		System.out.println("\nFim da execução");
	}

}
