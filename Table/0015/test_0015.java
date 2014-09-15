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
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.pdf.ColumnText;


public class test_0015
{
   public static final String PDF_FILENAME = "test_0015";


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
         p1.setAlignment(Element.ALIGN_JUSTIFIED);


         Paragraph p2 = new Paragraph("Vestibulum at ante tellus. "+
                                      "Fusce condimentum fermentum urna id dignissim. "+
                                      "Donec quis massa sed dolor consectetur convallis ut eu est. "+
                                      "Pellentesque at enim et augue fringilla lacinia. Sed laoreet lectus leo. "+
                                      "Sed sed malesuada purus. Maecenas imperdiet nec justo non blandit. "+
                                      "Ut nec turpis est. Mauris eu fringilla velit.");
         p2.setSpacingAfter(12);
         p2.setAlignment(Element.ALIGN_JUSTIFIED);

         Paragraph p3 = new Paragraph("Sed porttitor quam quis mauris viverra, sed rhoncus orci rhoncus. "+
                                      "Aliquam tincidunt varius nulla, ut eleifend dui facilisis non. In varius arcu massa. "+
                                      "Nulla id tellus mi. Suspendisse nec pulvinar elit. Maecenas ullamcorper lacus non fermentum tempus. "+
                                      "Suspendisse vitae urna sed ante molestie volutpat et sed dolor.");
         p3.setSpacingAfter(12);
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
         p4.setAlignment(Element.ALIGN_JUSTIFIED);

         Paragraph p5 = new Paragraph("Sed dapibus gravida tortor at vulputate. Nullam vel dictum nisl. "+
                                      "Morbi convallis porta erat a posuere. Phasellus ac hendrerit nisi. "+
                                      "Nunc cursus magna non risus tincidunt auctor. Donec porttitor nulla elit. "+
                                      "Suspendisse in mauris imperdiet, dictum est nec, aliquet sapien. Suspendisse potenti. "+
                                      "Nulla et vestibulum est. Proin tincidunt tortor a felis molestie placerat. "+
                                      "Proin ullamcorper accumsan nibh mollis lacinia.");
         p5.setSpacingAfter(12);
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
         p6.setAlignment(Element.ALIGN_JUSTIFIED);





         ColumnText ct = new ColumnText(writer.getDirectContent());
         ct.setAlignment(Element.ALIGN_JUSTIFIED);
         ct.setLeading(14);
         ct.setSimpleColumn(30, 100, 270, 800);

         ct.addElement(p1);
         ct.addElement(p2);
         ct.addElement(p3);

         ct.go();

         ct.setSimpleColumn(300, 100, 570, 800);

         ct.addElement(p4);
         ct.addElement(p5);
         ct.addElement(createTable());
         ct.addElement(p6);

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