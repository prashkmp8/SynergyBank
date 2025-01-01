FROM openjdk:17-alpine
LABEL "org.opencontainers.image.authors"="abc.com"
COPY target/BankGateway-0.0.1-SNAPSHOT.jar BankGateway-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "BankGateway-0.0.1-SNAPSHOT.jar"]