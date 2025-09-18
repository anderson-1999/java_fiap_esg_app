FROM ubuntu:latest
LABEL authors="anderson"

ENTRYPOINT ["top", "-b"]

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/esg_fiap-0.0.1-SNAPSHOT.jar /app/esg_fiap-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "esg_fiap-0.0.1-SNAPSHOT.jar"]