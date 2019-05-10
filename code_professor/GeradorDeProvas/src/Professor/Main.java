/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Professor;

/**
 *
 * @author bruno
 */
public class Main {
    
    public static void main(String[] args) {
		Professor
                        a = new Professor();
		a.setEmail("bruno@gmail.com");
		a.setSenha("123");
                a.setCpf(56153);
		a.setNome("Bruno Geovane");
		
		Professor
                        b = new Professor();
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
