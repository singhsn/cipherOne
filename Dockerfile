# Use the official OpenJDK 21 image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar cipher1-service.jar

# Expose the application port
EXPOSE 8098

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]