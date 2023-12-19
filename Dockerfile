FROM openjdk:17
EXPOSE 8081
ADD target/projectservice-0.0.1-SNAPSHOT.jar projectservice.jar
ENTRYPOINT ["java", "-jar", "/projectservice.jar"]