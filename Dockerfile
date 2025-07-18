# # Use an official OpenJDK runtime as a parent image
# FROM openjdk:21-jdk-slim

# # Set the working directory
# WORKDIR /app

# # Copy the built jar file (update the jar name if needed)
# COPY target/springboot-app-0.0.1-SNAPSHOT.jar app.jar

# # Expose port 8080
# EXPOSE 8080

# # Run the jar file
# ENTRYPOINT ["java", "-jar", "app.jar"]

# Stage 1: Build
FROM maven:3.8.8-openjdk-17-slim AS builder

WORKDIR /app

# Copy project files
COPY pom.xml .
COPY src ./src

# Run tests (optional)
RUN mvn test

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /app/target/springboot-app-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

