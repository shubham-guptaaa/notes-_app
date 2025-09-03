# Stage 1: Build
FROM maven:3.8.5-openjdk-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:21.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/notesFrontend-0.0.1-SNAPSHOT.jar notesFrontend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "notesFrontend.jar"]
