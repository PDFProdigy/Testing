test_0006
=========

"test_0006" is for testing table extraction in [PDFProdigy](http://www.pdfprodigy.com) with a very simple table (no headers and no spanning cells) but there is no visual border to the cells. Instead, some of the cells'background are painted in light gray.
In fact, when I say "no visual border", the borders are still here but their colors are the same as the background cell.
So, the borders are technically present.

![test_0006 screenshot](test_0006.png)

This PDF files was created by a Java program (_Cf._ test_XXXX.java in this folder) developped thanks to the ([IText Java library](http://itextpdf.com/)).

File list of this folder:

   - **README.md**: this file
   - **test_XXXX.pdf**: the PDF file (version 1.7)
   - **test_XXXX.png**: a screenshot of the table in PDF format
   - **test_XXXX.java**: the source of the Java program which created the PDF file
   - **compile.bat**: the DOS command line to compile the Java program
   - **run.bat**: the DOS command line to run the Java program
