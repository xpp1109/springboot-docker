FROM openjdk:17
LABEL Author="时振超"
WORKDIR /app
COPY target/docker-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080