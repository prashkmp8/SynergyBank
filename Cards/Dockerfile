FROM openjdk:17-alpine
LABEL "org.opencontainers.image.authors"="abc.com"
COPY target/Cards-0.0.1-SNAPSHOT.jar Cards-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "Cards-0.0.1-SNAPSHOT.jar"]