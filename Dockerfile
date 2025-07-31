# Etapa 1: construir con Maven
FROM maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: imagen final con solo el JAR
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY --from=builder /app/target/resenalibro-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]