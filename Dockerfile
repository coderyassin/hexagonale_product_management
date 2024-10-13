FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

COPY ./pom.xml ./

RUN --mount=type=cache,target=/root/.m2 mvn dependency:go-offline -B

COPY ./src ./src

ARG ACTIVE_PROFILE=dev

RUN if [ "$ACTIVE_PROFILE" = dev ]; \
    then mvn package; \
    else mvn package -DskipTests; \
    fi

FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar /app/app.jar

RUN apk update && apk add --no-cache curl

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
