test_0008
=========

"test_0008" is for testing table extraction in [PDFProdigy](http://www.pdfprodigy.com) with a very simple table (no headers and no spanning cells) but there is no border to the cells.
However, unlike "test_0007", each cell is not painted in light gray or white. Only 3 rows are painted in light gray.

![test_0008 screenshot](test_0008.png)

This PDF files was created by a Java program (_Cf._ test_XXXX.java in this folder) developped thanks to the ([IText Java library](http://itextpdf.com/)).

File list of this folder:

   - **README.md**: this file
   - **test_XXXX.pdf**: the PDF file (version 1.7)
   - **test_XXXX.png**: a screenshot of the table in PDF format
   - **test_XXXX.java**: the source of the Java program which created the PDF file
   - **compile.bat**: the DOS command line to compile the Java program
   - **run.bat**: the DOS command line to run the Java program
