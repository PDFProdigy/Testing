test_0007
=========

"test_0007" is for testing table extraction in [PDFProdigy](http://www.pdfprodigy.com) with a very simple table (no headers and no spanning cells) but there is no border to the cells.
Instead, some of the cells'background are painted in light gray.
However, unlike ["test_0006"](../test_0006), the borders were really removed from the table in this test.
Despite removing the border, you can see a little white line separating each gray cell. This kind of clue for helping table extraction is removed in ["test_0008"](../test_0008).

![test_0007 screenshot](test_0007.png)

This PDF files was created by a Java program (_Cf._ test_XXXX.java in this folder) developped thanks to the ([IText Java library](http://itextpdf.com/)).

File list of this folder:

   - **README.md**: this file
   - **test_XXXX.pdf**: the PDF file (version 1.7)
   - **test_XXXX.png**: a screenshot of the table in PDF format
   - **test_XXXX.java**: the source of the Java program which created the PDF file
   - **compile.bat**: the DOS command line to compile the Java program
   - **run.bat**: the DOS command line to run the Java program
