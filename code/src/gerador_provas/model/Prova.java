package gerador_provas.model;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import gerador_provas.dao.QuestaoDAO;

public class Prova {
	private int idprova;
	private Professor professor;
	private String cabecalho;
	private List<Questao> questoes = new ArrayList<Questao>();
	private int tipos;
	
	public int getIdprova() { return idprova; }
	
	public void setIdprova(int idprova) { this.idprova = idprova; }
	
	public Professor getProfessor() { return professor; }

	public void setProfessor(Professor professor) { this.professor = professor; }
	
	public String getCabecalho() { return cabecalho; }
	
	public void setCabecalho(String cabecalho) { this.cabecalho = cabecalho; }
	
	public List<Questao> getQuestoes() {
		return questoes;
	}
	
	public void setQuestoes(List<Questao> questoes) { this.questoes = questoes; }

	public int getTipos() { return tipos; }

	public void setTipos(int tipos) {this.tipos = tipos;}
	
	public void adicionaQuestao(int idquestao) {
		QuestaoDAO questaoDAO = new QuestaoDAO();
		Questao questao = questaoDAO.pesquisaId(idquestao);
		this.questoes.add(questao);
	}
	
	public String gerarPDF(Prova prova) {
		Document doc = new Document();
		String arquivoPDF = "/home/gustavofaquim/Downloads/prova.pdf";
		
		try {
			
			PdfWriter.getInstance(doc, new FileOutputStream(arquivoPDF));
			doc.open();
			
			Paragraph p = new Paragraph(prova.getCabecalho());
			p.setAlignment(1);
			doc.add(p);
			p = new Paragraph("\n\n");
			doc.add(p);
			
			for(Questao q: prova.getQuestoes()) {
				Paragraph questao = new Paragraph(q.getEnunciado());
				questao.setAlignment(0);
				doc.add(questao);
			}
			
			/*for(int i=0; i<= prova.getQuestoes().size(); i++) {
				System.out.println("Olaaaaaa");
				System.out.println(prova.getQuestoes().get(i).getEnunciado());
				Paragraph questao = new Paragraph(prova.getQuestoes().get(i).getEnunciado());
				questao.setAlignment(0);
				doc.add(questao);
				questao = new Paragraph("\n");
				doc.add(questao);
				
				for(int x = 0; x <= prova.getQuestoes().get(i).getAlternativas().length; x++) {
					System.out.println(prova.getQuestoes().get(i).getAlternativas()[x].getAlternativa());
					Paragraph alternativa = new Paragraph(prova.getQuestoes().get(i).getAlternativas()[x].getAlternativa());
					alternativa.setAlignment(2);
					doc.add(alternativa);
				}
			}*/
			
			doc.close();
			Desktop.getDesktop().open(new File(arquivoPDF));
		}catch(Exception e) {
			
		}
		return "Sucesso!";
	}
}
