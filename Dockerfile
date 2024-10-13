# Build stage
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app
COPY pom.xml .
RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline -B
COPY src ./src

# Development stage
FROM builder AS dev

ARG ACTIVE_PROFILE=dev
RUN mvn clean package -DskipTests -P${ACTIVE_PROFILE}

# Production stage
FROM builder AS prod

ARG ACTIVE_PROFILE=prod
RUN mvn clean package -P${ACTIVE_PROFILE}

# Final stage
FROM eclipse-temurin:21-jre-alpine AS final

WORKDIR /app
ARG ACTIVE_PROFILE
COPY --from=${ACTIVE_PROFILE} /app/target/*.jar /app/app.jar
RUN apk update && apk add --no-cache curl

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]