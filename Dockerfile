# Build stage
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline -B
COPY src ./src

# Development build stage
FROM builder AS dev

ARG ACTIVE_PROFILE=dev
RUN mvn clean package -DskipTests -P${ACTIVE_PROFILE}

# Production build stage
FROM builder AS prod

ARG ACTIVE_PROFILE=prod
RUN mvn clean package -P${ACTIVE_PROFILE}

# Final stage for development
FROM eclipse-temurin:21-jre-alpine AS dev-final

WORKDIR /app
COPY --from=dev /app/target/*.jar /app/app.jar
RUN apk update && apk add --no-cache curl

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Final stage for production
FROM eclipse-temurin:21-jre-alpine AS prod-final

WORKDIR /app
COPY --from=prod /app/target/*.jar /app/app.jar
RUN apk update && apk add --no-cache curl

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]