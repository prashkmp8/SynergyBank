FROM openjdk:17-alpine
LABEL "org.opencontainers.image.authors"="abc.com"
COPY target/BankConfigServer-0.0.1-SNAPSHOT.jar BankConfigServer-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "BankConfigServer-0.0.1-SNAPSHOT.jar"]