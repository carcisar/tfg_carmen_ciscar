# Build stage
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app/Planazo
COPY src-api/Planazo/ ./
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/Planazo/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/app.jar"]
