del groups.txt
del groups.xml
java -cp bin com.example.tests.GroupDataGenerator 5 groups.txt csv
java -cp bin;c:\javalibs\selenium\selenium-server-standalone-2.26.0.jar;c:\javalibs\xstream\xstream-1.4.3\lib\xstream-1.4.3.jar;c:\javalibs\xstream\xstream-1.4.3\lib\xstream\xpp3_min-1.1.4c.jar;c:\javalibs\xstream\xstream-1.4.3\lib\xstream\xmlpull-1.1.3.1.jar com.example.tests.GroupDataGenerator 5 groups.xml xml
java -cp bin;c:\javalibs\selenium\selenium-server-standalone-2.26.0.jar;c:\javalibs\xstream\xstream-1.4.3\lib\xstream-1.4.3.jar;c:\javalibs\xstream\xstream-1.4.3\lib\xstream\xpp3_min-1.1.4c.jar;c:\javalibs\xstream\xstream-1.4.3\lib\xstream\xmlpull-1.1.3.1.jar -DconfigFile=firefox.properties org.testng.TestNG testng-customsuite.xml
 