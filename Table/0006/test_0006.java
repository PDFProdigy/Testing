/**
 * This program creates a PDF file with a table in different PDF version (1.2 to 1.7).
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
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.BadElementException;


public class test_0006 
{
   public static final String PDF_FILENAME = "test_0006";
    

   private static PdfPTable
   createTable()
      throws BadElementException, DocumentException
      {
         PdfPTable table = new PdfPTable(5); // number of columns

         // Define the default design of the table cells
         table.getDefaultCell().setBorderColor(BaseColor.WHITE);
         table.getDefaultCell().setPadding(4);
         table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
         table.getDefaultCell().setBorderWidth(1);

         table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);

         // First row
         table.addCell("11");
         table.addCell("12");
         table.addCell("13");
         table.addCell("14");
         table.addCell("15");

         table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);

         // Second row
         table.addCell("21");
         table.addCell("22");
         table.addCell("23");
         table.addCell("24");
         table.addCell("25");

         table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);

         // Third row
         table.addCell("31");
         table.addCell("32");
         table.addCell("33");
         table.addCell("34");
         table.addCell("35");

         table.getDefaultCell().setBackgroundColor(BaseColor.WHITE);

         // Fourth row
         table.addCell("41");
         table.addCell("42");
         table.addCell("43");
         table.addCell("44");
         table.addCell("45");

         table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);

         // Fifth row
         table.addCell("51");
         table.addCell("52");
         table.addCell("53");
         table.addCell("54");
         table.addCell("55");

         return(table);
      }


   public static void
   createPDFFile(char __pdf_version)
      throws DocumentException, IOException 
      {
         Document  document = new Document();
         PdfWriter writer   = PdfWriter.getInstance(document, new FileOutputStream(PDF_FILENAME+"_v1."+__pdf_version+".pdf"));
         writer.setPdfVersion(__pdf_version);

         document.open();
         
         // Set the metadata
         document.addTitle(PDF_FILENAME);
         document.addSubject("Testing table extraction from PDF file");
         document.addKeywords("PDFProdigy, testing, table, extract");
         document.addAuthor("PDFProdigy.com");
         document.addCreator("PDFProdigy.com");

         // Add the table
         document.add(createTable());

         document.close();
      }


   public static void 
   main(String[] __args)
      throws DocumentException, IOException 
      {
         createPDFFile(PdfWriter.VERSION_1_2);
         createPDFFile(PdfWriter.VERSION_1_3);
         createPDFFile(PdfWriter.VERSION_1_4);
         createPDFFile(PdfWriter.VERSION_1_5);
         createPDFFile(PdfWriter.VERSION_1_6);
         createPDFFile(PdfWriter.VERSION_1_7);
      }
}