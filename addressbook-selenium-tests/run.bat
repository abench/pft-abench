del groups.txt
del groups.xml

SET TESTLIB=bin;c:\javalibs\selenium\selenium-server-standalone-2.26.0.jar;c:\javalibs\xstream\xstream-1.4.3\lib\xstream-1.4.3.jar;c:\javalibs\xstream\xstream-1.4.3\lib\xstream\xpp3_min-1.1.4c.jar;c:\javalibs\xstream\xstream-1.4.3\lib\xstream\xmlpull-1.1.3.1.jar
SET CONFIG_FILE=firefox.properties

java -cp %TESTLIB% com.example.tests.GroupDataGenerator 5 groups.txt csv
java -cp %TESTLIB% com.example.tests.GroupDataGenerator 5 groups.xml xml
java -cp %TESTLIB% -DconfigFile=%CONFIG_FILE% org.testng.TestNG testng-customsuite.xml
