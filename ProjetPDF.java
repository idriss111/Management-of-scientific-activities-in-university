package Metier;
import java.util.ArrayList;

import java.util.List;
import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.Element;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
public class ProjetPDF {
 private ArrayList<ProjetRecherche> projets;


public  ProjetPDF(ArrayList<ProjetRecherche> projets) {
	super();
	this.projets = projets;
}
public ArrayList<ProjetRecherche> getProjets() {
	return projets;
}
public void setProjets(ArrayList<ProjetRecherche> projets) {
	this.projets = projets;
}
private void writeTableHeader(PdfPTable table) {
    PdfPCell cell = new PdfPCell();
    cell.setBackgroundColor(Color.ORANGE);
    cell.setPadding(5);
     
    Font font = FontFactory.getFont(FontFactory.HELVETICA);
    font.setColor(Color.BLACK);
     
    cell.setPhrase(new Phrase("Titre", font));
     
    table.addCell(cell);
     
    cell.setPhrase(new Phrase("Description", font));
    table.addCell(cell);
     
    cell.setPhrase(new Phrase("Auteur", font));
    table.addCell(cell);
    
    cell.setPhrase(new Phrase("Budget", font));
    table.addCell(cell);
     
     
    
}
private void writeTableData(PdfPTable table) {
	 for (ProjetRecherche projet : projets) {
        table.addCell(projet.getTitre());
        table.addCell(projet.getDescription());
        table.addCell(projet.getAuteur());
        table.addCell(Integer.toString(projet.getBudget()));
        }
    }

public void export(HttpServletResponse response) throws DocumentException, IOException {
    Document document = new Document(PageSize.A4);
    PdfWriter.getInstance(document, response.getOutputStream());
     
    document.open();
    Font font = FontFactory.getFont(FontFactory.TIMES_ITALIC);
    font.setSize(18);
    font.setColor(Color.BLACK);
     
    Paragraph p = new Paragraph("Liste des projets ", font);
    p.setAlignment(Paragraph.ALIGN_CENTER);
     
    document.add(p);
     
    PdfPTable table = new PdfPTable(4);
    table.setWidthPercentage(100f);
    table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
    table.setSpacingBefore(10);
     
    writeTableHeader(table);
    writeTableData(table);
    document.add(table);
    document.close();
     
}


}


