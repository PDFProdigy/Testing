
@echo off

for %%* in (.) do set current_directory_na=%%~n*

java -cp ../../Lib/itextpdf-5.5.0.jar;. test_%current_directory_na%
