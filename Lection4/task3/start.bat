@echo
start ElectronicRegistry.jar
@echo off
echo Enter a param1:
rem
copy p1.bat+CON temp.bat>nul
rem
call temp.bat
rem
set p1=%p%
echo you have entered a param1: %p1%

echo Enter a param2:
rem
copy p1.bat+CON temp.bat>nul

call temp.bat 
set p2=%p%
rem
echo you have entered a param2: %p2%
del temp.bat>nul
rem
exit