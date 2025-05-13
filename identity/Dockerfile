# Use lightweight OpenJDK 17 base image
FROM openjdk:17-jdk-alpine

# Expose the app port (match this with Docker Compose)
EXPOSE 8082

# Create app directory
WORKDIR /app

# Copy the built JAR (override during build if needed)
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
