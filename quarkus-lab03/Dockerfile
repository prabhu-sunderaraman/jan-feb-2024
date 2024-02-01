FROM openjdk:17-alpine
COPY build/quarkus-lab03-1.0-SNAPSHOT-runner.jar app.jar
EXPOSE 8080
ENV DB_USERNAME=root
ENV DB_PASSWORD=default
ENV DB_HOST=127.0.0.1
CMD ["java", "-jar", "app.jar"]

#docker run --name lab03 --rm -p8080:8080 -e DB_HOST=host.docker.internal -e DB_PASSWORD=root  quarkus-lab03:1.0.0
#CMD ["java", "-jar", "-Dquarkus.datasource.jdbc.url=jdbc:mysql://host.docker.internal:3306/training", "app.jar"]
