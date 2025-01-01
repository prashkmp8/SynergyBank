FROM openjdk:17-alpine
LABEL "org.opencontainers.image.authors"="abc.com"
COPY target/BankDiscoveryService-0.0.1-SNAPSHOT.jar BankDiscoveryService-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "BankDiscoveryService-0.0.1-SNAPSHOT.jar"]