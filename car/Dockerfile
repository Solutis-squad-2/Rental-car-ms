FROM openjdk:21-jdk-slim
RUN mkdir /Carro
WORKDIR /Carro
COPY target/*.jar /Carro/Carro.jar
RUN ls -al /Carro
CMD ["java","-jar","/Carro/Carro.jar"]
