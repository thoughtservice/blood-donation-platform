Blood donation Platform project  

# Quick Start  

## IDE setup

For the usage inside an IDE do the following:

1. Make sure you have an Eclipse with m2e installed (preferably STS).
2. Install Lombok.

Download it from the [project page](http://projectlombok.org/download.html)
* Run the JAR (double click or java -jar …)
* Point it to your Eclipse installation, run the install
* Restart Eclipse

## Checkout Project  
```
git clone git@github.com:thoughtservice/blood-donation-platform.git  
```

## Compile and import project to eclipse
```
cd blood-donation-platform  
mvn eclipse:clean  
mvn eclipse:eclipse -DdownloadSources=true
```
Import the checked out code through File > Import > Existing Maven Project

## Running the WAR
```
mvn clean package  
cd blooddonationapi  
java -jar target/*.war  
```

Embedded tomcat container is available and application can be browsed using the url    
[http://localhost:8080/browser/index.html](http://localhost:8080/browser/index.html)

