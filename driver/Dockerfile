FROM openjdk:21-jdk-slim
RUN mkdir /driver
WORKDIR /driver
COPY target/*.jar /driver/driver.jar
RUN ls -al /driver
CMD ["java","-jar","/driver/driver.jar"]
