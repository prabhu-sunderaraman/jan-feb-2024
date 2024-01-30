#If I give you a jar file and ask you to run it
#You will need to install jdk
#Copy the jar file to some folder
#Navigate to that folder
#Run the jar file

FROM openjdk:17-alpine
COPY build/palindrome-api-1.0.0-runner.jar /app.jar
EXPOSE 8082
CMD ["java", "-jar", "-Dquarkus.http.port=8082", "/app.jar"]