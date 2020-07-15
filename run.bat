set projectLocation=D:\Goutham's folder\MagneQ_software_testing_course\MagneQ_workspace for selinium programs\Framework
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\TestNGTestcases.xml