/**
 * This program creates a PDF file (version 1.7) with a table.
 * The purpose of this PDF file is to test and control the efficacity of table extraction from PDF documents.
 *
 * This code was developped thanks to the Java library IText (http://itextpdf.com/)
 * The jar file can be retrieved from the maven repository : http://mvnrepository.com/artifact/com.itextpdf/itextpdf
 * The IText API documentation is available here : http://api.itextpdf.com/itext/index.html?overview-summary.html
 *
 * To compile : javac -cp ..\..\Lib\itextpdf-5.5.0.jar   test_xxxx.java
 * To run     : java  -cp ..\..\Lib\itextpdf-5.5.0.jar;. test_xxxx
 */


import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.pdf.ColumnText;


public class test_0017
{
   public static final String PDF_FILENAME = "test_0017";


   private static PdfPTable
   createTable(String __table_name)
      throws BadElementException, DocumentException
      {
         PdfPTable table = new PdfPTable(5); // number of columns

         // Define the default design of the table cells
         table.getDefaultCell().setBorderColor(BaseColor.BLACK);
         table.getDefaultCell().setPadding(4);
         table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
         table.getDefaultCell().setBorderWidth(1);

         // First row
         table.addCell(__table_name+".11");
         table.addCell(__table_name+".12");
         table.addCell(__table_name+".13");
         table.addCell(__table_name+".14");
         table.addCell(__table_name+".15");

         // Second row
         table.addCell(__table_name+".21");
         table.addCell(__table_name+".22");
         table.addCell(__table_name+".23");
         table.addCell(__table_name+".24");
         table.addCell(__table_name+".25");

         // Third row
         table.addCell(__table_name+".31");
         table.addCell(__table_name+".32");
         table.addCell(__table_name+".33");
         table.addCell(__table_name+".34");
         table.addCell(__table_name+".35");

         // Fourth row
         table.addCell(__table_name+".41");
         table.addCell(__table_name+".42");
         table.addCell(__table_name+".43");
         table.addCell(__table_name+".44");
         table.addCell(__table_name+".45");

         return(table);
      }


   public static void
   createPDFFile()
      throws DocumentException, IOException
      {
         Document  document = new Document();
         PdfWriter writer   = PdfWriter.getInstance(document, new FileOutputStream(PDF_FILENAME+".pdf"));
         writer.setPdfVersion(PdfWriter.VERSION_1_7);

         document.open();

         // Set the metadata
         document.addTitle(PDF_FILENAME);
         document.addSubject("Testing table extraction from PDF file");
         document.addKeywords("PDFProdigy, testing, table, extract");
         document.addAuthor("PDFProdigy.com");
         document.addCreator("PDFProdigy.com");

         // Add the table

         ColumnText ct = new ColumnText(writer.getDirectContent());
         ct.setAlignment(Element.ALIGN_JUSTIFIED);
         ct.setLeading(14);

         ct.setSimpleColumn(42, 500, 302, 800);
         ct.addElement(createTable("T1"));

         ct.go();

         ct.setSimpleColumn(0, 100, 260, 700);
         ct.addElement(createTable("T2"));

         ct.go();

         ct.setSimpleColumn(291, 500, 551, 780);
         ct.addElement(createTable("T3"));

         ct.go();

         ct.setSimpleColumn(249, 100, 509, 680);
         ct.addElement(createTable("T4"));

         ct.go();


         document.close();
      }


   public static void
   main(String[] __args)
      throws DocumentException, IOException
      {
         createPDFFile();
      }
}