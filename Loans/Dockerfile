FROM openjdk:17-alpine
LABEL "org.opencontainers.image.authors"="abc.com"
COPY target/Loans-0.0.1-SNAPSHOT.jar Loans-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "Loans-0.0.1-SNAPSHOT.jar"]