package gerador_provas.model;

import java.io.FileOutputStream;
import java.io.IOException;
  
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
  
public static final String RESULT = "";
  
public static void main(String[] args) throws DocumentException, IOException {
         Document document = new Document();
         PdfWriter.getInstance(document, new FileOutputStream(RESULT));
         document.open();
         document.add(new Paragraph("Primeiro Exemplo com iText!"));
         document.close();
}