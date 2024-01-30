FROM openjdk:17-alpine
COPY build/word-api-1.0.0-runner.jar /app.jar
EXPOSE 8080
CMD ["java", "-jar", "-Dquarkus.http.port=8080", "-Dpalindrome.api.server=host.docker.internal", "-Dpalindrome.api.port=8082", "/app.jar"]