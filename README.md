Blood donation Platform project  

Quick Start  

**For importing project to eclipse**  
cd blood-donation-platform  
mvn eclipse:clean  
mvn eclipse:eclipse  

**For running the project**  
git clone git@github.com:thoughtservice/blood-donation-platform.git  
mvn clean package  
cd blooddonationapi  
java -jar target/*.war  

Embedded tomcat container is available and application can be browsed using the url    
http://localhost:8080/browser/index.html

