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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.pdf.BaseFont;

public class test_0008 
{
   public static final String PDF_FILENAME = "test_0008";
    

   private static void
   writeTable(PdfWriter __writer)
      throws BadElementException, DocumentException, IOException
      {
         PdfContentByte canvas = __writer.getDirectContent();
         canvas.saveState();

         float origin_x    = 50f;
         float origin_y    = 650f;
         float cell_width  = 30f;
         float cell_height = 30f;

         int nb_rows    = 5;
         int nb_columns = 5;

         canvas.setColorStroke(BaseColor.LIGHT_GRAY);
         canvas.setColorFill(BaseColor.LIGHT_GRAY);

         // Fill a row with gray very two rows
         for (int i=0; i < nb_rows; i+=2)
            {
               canvas.rectangle(origin_x, origin_y+cell_height*i, cell_width*nb_columns, cell_height);
               canvas.fillStroke();               
            }

         canvas.setColorFill(BaseColor.BLACK);

         BaseFont bf = BaseFont.createFont();

         canvas.beginText();
         canvas.setFontAndSize(bf, 12);

         // Write the content of each cell
         for (int i=0; i<nb_columns; i++)
            {
               for (int j=0; j<nb_rows; j++)
                  {
                     canvas.showTextAligned(Element.ALIGN_CENTER, (nb_rows-j)+""+(i+1), origin_x+cell_width*i+cell_width/2f, origin_y+cell_height*j+cell_height/2.5f, 0);
                  }
            }
         canvas.endText();

         canvas.restoreState();
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
         writeTable(writer);

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