/**
 * This program creates a PDF file with graphic objects in different PDF version (1.2 to 1.7).
 * The purpose of this PDF file is to test and control the efficacity of graphic object extraction from PDF documents.
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
import com.itextpdf.text.Rectangle;
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
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.BadElementException;


public class test_0201 
{
   public static final String PDF_FILENAME = "test_0201";
    

   private static void
   writeGraphicObjects(PdfWriter __writer)
      throws BadElementException, DocumentException, IOException
      {
         PdfContentByte canvas = __writer.getDirectContent();

         canvas.setRGBColorFill(0xFF, 0x00, 0x00);
         canvas.rectangle(10, 10, 50, 50);
         canvas.fill();

         canvas.setLineWidth(3);
         canvas.setRGBColorFill(0x00, 0xFF, 0x00);
        
         canvas.rectangle(50, 20, 50, 50);
         canvas.fillStroke();

         canvas.setRGBColorFill(0x00, 0x00, 0xFF);
         canvas.setRGBColorStroke(0x00, 0xFF, 0xFF);

         canvas.rectangle(90, 30, 50, 50);
         canvas.fill();

         canvas.rectangle(130, 40, 50, 50);
         canvas.stroke();


/*
         // state 1:
         canvas.setRGBColorFill(0xFF, 0x45, 0x00);
         
         // fill a rectangle in state 1
         canvas.rectangle(10, 10, 60, 60);
         canvas.fill();
         canvas.saveState();
        
         // state 2;
         canvas.setLineWidth(3);
         canvas.setRGBColorFill(0x8B, 0x00, 0x00);
        
         // fill and stroke a rectangle in state 2
         canvas.rectangle(40, 20, 60, 60);
         canvas.fillStroke();
         canvas.saveState();
        
         // state 3:
         canvas.concatCTM(1, 0, 0.1f, 1, 0, 0);
         canvas.setRGBColorStroke(0xFF, 0x45, 0x00);
         canvas.setRGBColorFill(0xFF, 0xD7, 0x00);
        
         // fill and stroke a rectangle in state 3
         canvas.rectangle(70, 30, 60, 60);
         canvas.fillStroke();
         canvas.restoreState();
         
         // stroke a rectangle in state 2
         canvas.rectangle(100, 40, 60, 60);
         canvas.stroke();
         canvas.restoreState();

         // fill and stroke a rectangle in state 1
         canvas.rectangle(130, 50, 60, 60);
         canvas.fillStroke();      
*/         
      }


   public static void
   createPDFFile(char __pdf_version)
      throws DocumentException, IOException 
      {
         Document  document = new Document(new Rectangle(200, 120));
         PdfWriter writer   = PdfWriter.getInstance(document, new FileOutputStream(PDF_FILENAME+"_v1."+__pdf_version+".pdf"));
         writer.setPdfVersion(__pdf_version);

         document.open();
        
         // Set the metadata
         document.addTitle(PDF_FILENAME);
         document.addSubject("Testing graphic object extraction from PDF file");
         document.addKeywords("PDFProdigy, testing, graphic, object, extract");
         document.addAuthor("PDFProdigy.com");
         document.addCreator("PDFProdigy.com");

         // Add graphic objects
         writeGraphicObjects(writer);

         document.close();
      }


   public static void 
   main(String[] __args)
      throws DocumentException, IOException 
      {
         // createPDFFile(PdfWriter.VERSION_1_2);
         // createPDFFile(PdfWriter.VERSION_1_3);
         // createPDFFile(PdfWriter.VERSION_1_4);
         // createPDFFile(PdfWriter.VERSION_1_5);
         // createPDFFile(PdfWriter.VERSION_1_6);
         createPDFFile(PdfWriter.VERSION_1_7);
      }
}