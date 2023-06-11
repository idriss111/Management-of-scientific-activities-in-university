package Metier;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class Deml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document document = new Document();
		try
		{
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("demo.pdf"));
		document.open();
		document.add(new Paragraph("This is Demo PDF"));
		document.close();
		writer.close();
		System.out.print("iciiii");
		} catch (DocumentException e)
		{
		e.printStackTrace();
		} catch (FileNotFoundException e)
		{
		e.printStackTrace();
		}
		}
		}
	


