FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app
COPY ./pom.xml ./
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline -B
COPY ./src ./src

FROM builder AS dev

WORKDIR /app
ARG ACTIVE_PROFILE=dev
RUN mvn clean package -DskipTests
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=dev /app/target/*.jar /app/app.jar
RUN apk update && apk add --no-cache curl
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

FROM builder AS prod

WORKDIR /app
ARG ACTIVE_PROFILE=prod
RUN mvn clean package
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=prod /app/target/*.jar /app/app.jar
RUN apk update && apk add --no-cache curl
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
