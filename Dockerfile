# Stage 1: Build the application with Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Set up the runtime environment
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Expose the necessary port
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
