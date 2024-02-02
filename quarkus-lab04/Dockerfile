FROM openjdk:17-alpine
COPY build/quarkus-lab04-1.0-SNAPSHOT-runner.jar app.jar
EXPOSE 8080
ENV DB_HOST=localhost
ENV DB_PORT=3306
ENV DB_USER=ROOT
ENV DB_PASSWORD=ROOT
CMD ["java", "-jar", "app.jar"]