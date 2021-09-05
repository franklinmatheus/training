FROM maven:3.5-jdk-8 AS build
COPY src /app/src/
COPY pom.xml /app/
WORKDIR /app
RUN mvn clean package