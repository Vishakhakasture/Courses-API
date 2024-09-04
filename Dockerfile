
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/course-api.jar course-api.jar
COPY src/main/resources/application.yml application.yml

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "course-api.jar"]
