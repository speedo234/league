# backend challenge

Apache Maven (v3.6.3)
Spring Boot (v2.5.3)
Java 8
application port => 8080
Swagger (v3.0.0) url => http://localhost:8080/swagger-ui/index.html



INSTRUCTIONS TO BUILD AND RUN
---
1. Open command line and CD to the directory containing the pom.xml file.
2. Run the following command => mvn clean install package.
3. CD into the generated target folder.
4. Run the jar file with the following command => java -jar league-0.0.1-SNAPSHOT.jar
5. Specified port in the application.properties file is => server.port = 8080
6. If you need to specify a different port for obvious reasons; use this command to run the jar file java -jar league-0.0.1-SNAPSHOT.jar --server.port=YOUR_PREFERRED_PORT_NUMBER


TESTING THE FUNCTIONALITY
---
1. Open a web browser and enter the following url => http://localhost:8080/swagger-ui/index.html
2. Remember to replace 8080 with the value of --server.port
3. Alternatively, you can test the application using postman or any other tool for testing web services.


