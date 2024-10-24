# Use uma imagem base do OpenJDK
FROM openjdk:21-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado pelo Maven para dentro do contêiner
COPY target/Carrinho-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que a aplicação Spring Boot vai usar
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
