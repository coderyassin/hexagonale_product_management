FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

COPY ./pom.xml ./  

RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline -B

COPY ./src ./src

RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/app.jar

RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
