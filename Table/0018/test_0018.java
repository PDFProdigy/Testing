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
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.pdf.ColumnText;


public class test_0018
{
   public static final String PDF_FILENAME = "test_0018";



   private static void
   writeTable(PdfWriter __writer)
      throws BadElementException, DocumentException, IOException
      {
         PdfContentByte canvas = __writer.getDirectContent();
         canvas.saveState();

         float origin_x    = 215f;
         float origin_y    = 230f;
         float cell_width  = 30f;
         float cell_height = 30f;

         int nb_rows    = 5;
         int nb_columns = 5;

         // canvas.setColorStroke(BaseColor.LIGHT_GRAY);
         // canvas.setColorFill(BaseColor.LIGHT_GRAY);

         // // Fill a row with gray every two rows
         // for (int i=0; i < nb_rows; i+=2)
         //    {
         //       canvas.rectangle(origin_x, origin_y+cell_height*i, cell_width*nb_columns, cell_height);
         //       canvas.fillStroke();
         //    }

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

         Font font = new Font(FontFamily.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK);

         writer.getDirectContent().setFontAndSize(BaseFont.createFont(), 6);
         // Add the table
         Paragraph p1 = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "+
                                      "Donec consequat pharetra urna, at cursus eros vulputate eget. "+
                                      "Suspendisse bibendum semper rutrum. "+
                                      "Quisque adipiscing congue nisi sit amet auctor. "+
                                      "Nulla aliquet ornare nunc vitae luctus. "+
                                      "Sed sit amet enim ut sapien feugiat dictum eget eu lacus. "+
                                      "Suspendisse ligula enim, tempus in quam quis, convallis egestas tortor. "+
                                      "Vivamus imperdiet mi vitae pharetra adipiscing. "+
                                      "Maecenas nisl tellus, consectetur nec neque quis, euismod tincidunt nulla. "+
                                      "Aenean accumsan consectetur aliquam. In at elit sit amet lacus fringilla aliquet. "+
                                      "Praesent commodo luctus dapibus. Duis rhoncus ipsum id ipsum ornare, a lacinia turpis hendrerit. "+
                                      "Cras convallis, enim eget rutrum vulputate, diam dolor pharetra turpis, sit amet ultrices erat nulla ac diam.");
         p1.setSpacingAfter(12);
         p1.setFont(font);
         p1.setAlignment(Element.ALIGN_JUSTIFIED);


         Paragraph p2 = new Paragraph("Vestibulum at ante tellus. "+
                                      "Fusce condimentum fermentum urna id dignissim. "+
                                      "Donec quis massa sed dolor consectetur convallis ut eu est. "+
                                      "Pellentesque at enim et augue fringilla lacinia. Sed laoreet lectus leo. "+
                                      "Sed sed malesuada purus. Maecenas imperdiet nec justo non blandit. "+
                                      "Ut nec turpis est. Mauris eu fringilla velit.");
         p2.setSpacingAfter(12);
         p2.setFont(font);
         p2.setAlignment(Element.ALIGN_JUSTIFIED);

         Paragraph p3 = new Paragraph("Sed porttitor quam quis mauris viverra, sed rhoncus orci rhoncus. "+
                                      "Aliquam tincidunt varius nulla, ut eleifend dui facilisis non. In varius arcu massa. "+
                                      "Nulla id tellus mi. Suspendisse nec pulvinar elit. Maecenas ullamcorper lacus non fermentum tempus. "+
                                      "Suspendisse vitae urna sed ante molestie volutpat et sed dolor.");
         p3.setSpacingAfter(12);
         p3.setFont(font);
         p3.setAlignment(Element.ALIGN_JUSTIFIED);

         Paragraph p4 = new Paragraph("Suspendisse potenti. Cras tempor augue eu justo fringilla aliquet. "+
                                      "Donec in augue dui. Fusce auctor nibh non congue scelerisque. "+
                                      "Interdum et malesuada fames ac ante ipsum primis in faucibus. "+
                                      "Interdum et malesuada fames ac ante ipsum primis in faucibus. "+
                                      "Vivamus elementum dui vitae magna scelerisque dictum. Etiam nec scelerisque nibh. "+
                                      "Morbi nec posuere felis. Nam sem mauris, semper quis hendrerit a, convallis nec tortor. "+
                                      "Donec eu tristique ante. Nunc interdum odio at tempus imperdiet. Vivamus nec convallis enim. "+
                                      "Quisque in sollicitudin lorem.");
         p4.setSpacingAfter(12);
         p4.setFont(font);
         p4.setAlignment(Element.ALIGN_JUSTIFIED);

         Paragraph p5 = new Paragraph("Sed dapibus gravida tortor at vulputate. Nullam vel dictum nisl. "+
                                      "Morbi convallis porta erat a posuere. Phasellus ac hendrerit nisi. "+
                                      "Nunc cursus magna non risus tincidunt auctor. Donec porttitor nulla elit. "+
                                      "Suspendisse in mauris imperdiet, dictum est nec, aliquet sapien. Suspendisse potenti. "+
                                      "Nulla et vestibulum est. Proin tincidunt tortor a felis molestie placerat. "+
                                      "Proin ullamcorper accumsan nibh mollis lacinia.");
         p5.setSpacingAfter(182);
         p5.setFont(font);
         p5.setAlignment(Element.ALIGN_JUSTIFIED);

         Paragraph p6 = new Paragraph("Cras id ligula at turpis porta fringilla sed luctus nunc. "+
                                      "Nunc ultricies odio et ante consequat, nec molestie urna feugiat. "+
                                      "Donec at congue tellus. "+
                                      "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. "+
                                      "Cras suscipit convallis neque, sit amet adipiscing nisl hendrerit non. "+
                                      "Etiam ornare viverra massa. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "+
                                      "Vivamus tincidunt egestas condimentum. Etiam luctus quam at congue bibendum. "+
                                      "Proin fermentum velit nisl, ac bibendum ante porta sed.");
         p6.setSpacingAfter(12);
         p6.setFont(font);
         p6.setAlignment(Element.ALIGN_JUSTIFIED);

         Paragraph p7 = new Paragraph("Aliquam ac mauris nibh. Nulla consequat lectus a nisl bibendum, sed rutrum mauris condimentum. "+
                                      "Curabitur viverra feugiat hendrerit. "+
                                      "Nulla eleifend, elit eget malesuada faucibus, neque erat dapibus elit, ut aliquam erat augue non arcu. "+
                                      "Donec tristique mi nec dignissim vestibulum. "+
                                      "Cras posuere metus at tortor facilisis, et pretium felis sollicitudin. "+
                                      "Duis ac enim suscipit, ullamcorper augue ac, varius elit. "+
                                      "Donec nec euismod massa, sit amet posuere mauris. Integer nec malesuada est, in euismod augue. "+
                                      "Nam aliquam, mi in tempor lobortis, orci ligula commodo erat, eu tempus eros nisi in odio. "+
                                      "Cras eu tristique nibh, at fermentum sem. Suspendisse hendrerit pharetra rutrum.");
         p7.setSpacingAfter(12);
         p7.setFont(font);
         p7.setAlignment(Element.ALIGN_JUSTIFIED);

         Paragraph p8 = new Paragraph("Sed nec eros euismod, convallis nulla ac, faucibus odio. "+
                                      "Vivamus aliquet tellus vitae placerat iaculis. "+
                                      "Fusce metus lorem, facilisis et consequat nec, luctus sit amet tortor. "+
                                      "Aenean bibendum a orci eget consequat. Nullam quis urna nunc. "+
                                      "Donec ultrices egestas nisl non adipiscing. Nulla congue orci non odio consequat pretium. "+
                                      "Etiam facilisis diam purus.");
         p8.setSpacingAfter(12);
         p8.setFont(font);
         p8.setAlignment(Element.ALIGN_JUSTIFIED);




         ColumnText ct = new ColumnText(writer.getDirectContent());
         ct.setAlignment(Element.ALIGN_JUSTIFIED);
         ct.setLeading(14);
         ct.setSimpleColumn(20, 100, 190, 800);

         ct.addElement(p1);
         ct.addElement(p2);
         ct.addElement(p3);

         ct.go();

         ct.setSimpleColumn(210, 100, 380, 800);

         ct.addElement(p4);
         // ct.addElement(createTable());
         writeTable(writer);
         ct.addElement(p5);
         ct.addElement(p6);

         ct.go();

         ct.setSimpleColumn(400, 100, 570, 800);

         ct.addElement(p7);
         ct.addElement(p8);

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