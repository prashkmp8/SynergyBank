FROM openjdk:17-alpine
LABEL "org.opencontainers.image.authors"="abc.com"
COPY target/Accounts-0.0.1-SNAPSHOT.jar Accounts-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "Accounts-0.0.1-SNAPSHOT.jar"]