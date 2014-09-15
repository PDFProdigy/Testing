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
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.pdf.BaseFont;

public class test_0009
{
   public static final String PDF_FILENAME = "test_0009";


   private static void
   writeTable(PdfWriter __writer)
      throws BadElementException, DocumentException, IOException
      {
         PdfContentByte canvas = __writer.getDirectContent();
         canvas.saveState();
         canvas.setLineWidth(0.1f);

         float origin_x    = 50f;
         float origin_y    = 700f;
         float cell_width  = 40f;
         float cell_height = 40f;

         // the gap size between each cell borders.
         float separator = 3f;
         for (int i=0; i <= 5; i++)
            {
               for (int j=0; j <= 3; j++)
                  {
                     if (i < 5)
                        {
                           // Horizontal line
                           canvas.moveTo( origin_x+separator+    i*cell_width, origin_y+j*cell_height);
                           canvas.lineTo( origin_x-separator+(i+1)*cell_width, origin_y+j*cell_height);
                           canvas.stroke();
                        }

                     if (j < 3)
                        {
                           // Vertical Line
                           canvas.moveTo( origin_x+i*cell_width, origin_y+separator+    j*cell_height);
                           canvas.lineTo( origin_x+i*cell_width, origin_y-separator+(j+1)*cell_height);
                           canvas.stroke();
                        }
                  }
            }

         BaseFont bf = BaseFont.createFont();

         canvas.beginText();
         canvas.setFontAndSize(bf, 12);
         for (int i=0; i<5; i++)
            {
               for (int j=0; j<3; j++)
                  {
                     canvas.showTextAligned(Element.ALIGN_CENTER, (3-j)+""+(i+1), origin_x+cell_width*i+cell_width/2f, origin_y+cell_height*j+cell_height/2.5f, 0);
                  }
            }
         canvas.endText();

         canvas.restoreState();
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
         writeTable(writer);

         document.close();
      }


   public static void
   main(String[] __args)
      throws DocumentException, IOException
      {
         createPDFFile();
      }
}