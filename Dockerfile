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
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
