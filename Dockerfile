FROM maven:3.9.8-eclipse-temurin-17 AS build

# Cria um diretório para armazenar os arquivos do projeto
RUN mkdir /opt/app

# Copia todos os arquivos do projeto para dentro do container
COPY . /opt/app

# Define o diretório de trabalho dentro do container
WORKDIR /opt/app

# Executa o build do projeto, gerando o arquivo JAR
RUN mvn clean package -DskipTests

# Etapa de runtime: usa uma imagem leve com apenas o JRE para rodar o app
FROM eclipse-temurin:17-jre-alpine

# Cria o diretório da aplicação no ambiente final
RUN mkdir /opt/app

# Copia o JAR gerado na etapa de build para a imagem final
COPY --from=build  /opt/app/target/esg_fiap-0.0.1-SNAPSHOT.jar /opt/app/app.jar

# Define o diretório de trabalho
WORKDIR /opt/app

# Define a variável de ambiente do profile (pode ser dev, prd, etc.)
ENV PROFILE=prd
ENV DATABASE_PWD="12345"
ENV DATABASE_USER="sys AS sysdba"
ENV DATABASE_URL="jdbc:oracle:thin:@localhost:1521:xe"

# Expõe a porta 8080 (porta padrão da aplicação Spring Boot)
EXPOSE 8080

# Comando de inicialização, interpolando a variável PROFILE corretamente
ENTRYPOINT  ["java", "-Dspring.profiles.active=${PROFILE}", "-Dspring.datasource.url=${DATABASE_URL}", "-Dspring.datasource.username=${DATABASE_USER}", "-Dspring.datasource.password=${DATABASE_PWD}", "-jar", "app.jar"]
