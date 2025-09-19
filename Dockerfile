FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/esg_fiap-0.0.1-SNAPSHOT.jar /app/esg_fiap-0.0.1-SNAPSHOT.jar

ENV SPRING_DATASOURCE_URL="jdbc:oracle:thin:@localhost:1521:xe"
ENV SPRING_DATASOURCE_USERNAME="sys as sysdba"
ENV SPRING_DATASOURCE_PASSWORD=12345

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/esg_fiap-0.0.1-SNAPSHOT.jar", "-e", "$SPRING_DATASOURCE_USERNAME"]