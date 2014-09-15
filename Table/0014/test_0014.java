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


public class test_0014
{
   public static final String PDF_FILENAME = "test_0014";


   private static PdfPTable
   createTable()
      throws BadElementException, DocumentException
      {
         PdfPTable table = new PdfPTable(5); // number of columns

         // Define the default design of the table cells
         table.getDefaultCell().setBorderColor(BaseColor.BLACK);
         table.getDefaultCell().setPadding(4);
         table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
         table.getDefaultCell().setBorderWidth(1);

         // First row
         table.addCell("11");
         table.addCell("12");
         table.addCell("13");
         table.addCell("14");
         table.addCell("15");

         // Second row
         table.addCell("21");
         table.addCell("22");
         table.addCell("23");
         table.addCell("24");
         table.addCell("25");

         // Third row
         table.addCell("31");
         table.addCell("32");
         table.addCell("33");
         table.addCell("34");
         table.addCell("35");

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
         Paragraph p1 = new Paragraph("Lorem ipsum dolor sit amet, an sit alia sensibus. "+
                                      "Duo nisl consequuntur in, natum aeterno inciderint pro at. "+
                                      "Eu vix antiopam sententiae, est id verterem postulant. Quot detraxit volutpat te est. "+
                                      "Usu cibo habeo ei. Tamquam bonorum interpretaris vim an, et per amet tritani viderer, "+
                                      "ad malorum meliore per. Ea pro elitr inimicus, ut quodsi regione deseruisse eos.\n");
         p1.setSpacingAfter(12);

         document.add(p1);

         document.add(createTable());

         Paragraph p2 = new Paragraph("Ei elit nusquam intellegat sed. Eruditi epicurei singulis duo te, eius malis ad his, "+
                                      "labore omittantur cum ei. No pro nulla iuvaret, nisl postulant ex eum. "+
                                      "Option ullamcorper consequuntur pri ea. Saepe labitur eos eu, ut pri nostrum euripidis. "+
                                      "Stet erant ornatus quo in, ut tollit recusabo mel, ei semper viderer periculis eum. "+
                                      "Ut nam tale impetus, ei inani prompta his.");
         document.add(p2);

         document.close();
      }


   public static void
   main(String[] __args)
      throws DocumentException, IOException
      {
         createPDFFile();
      }
}