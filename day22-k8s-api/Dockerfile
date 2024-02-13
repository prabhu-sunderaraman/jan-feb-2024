FROM openjdk:17-alpine
COPY build/day22-k8s-api-1.0-SNAPSHOT-runner.jar app.jar
ENV WELCOME "Welcome from Dockerfile"
ENV BYE "Bye from Dockerfile"
CMD ["java", "-jar", "app.jar"]
