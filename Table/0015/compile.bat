@echo off

for %%* in (.) do set current_directory_na=%%~n*

javac -cp ../../Lib/itextpdf-5.5.0.jar test_%current_directory_na%.java
