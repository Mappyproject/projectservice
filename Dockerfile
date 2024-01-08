FROM openjdk:17
EXPOSE 8081
COPY target/projectservice-0.0.1-SNAPSHOT.jar projectservice.jar
ENTRYPOINT ["java", "-jar", "/projectservice.jar"]