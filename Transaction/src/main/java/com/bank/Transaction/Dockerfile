# Use a Java base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file (build the JAR using Maven/Gradle beforehand)
COPY target/microservice2.jar /app/microservice2.jar

# Expose the port that the application will run on
EXPOSE 8081

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "/app/microservice2.jar"]
