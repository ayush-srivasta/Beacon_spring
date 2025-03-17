# Use OpenJDK as base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy built JAR file into the container
COPY target/Beacon-0.0.1-SNAPSHOT.jar Beacon-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "Beacon-0.0.1-SNAPSHOT.jar"]