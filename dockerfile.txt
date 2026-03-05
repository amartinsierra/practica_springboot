FROM openjdk:21-ea-jdk-slim

COPY buscador.jar buscador.jar

ENV SPRING_PROFILES_ACTIVE=prod

ENV HOST_DB=192.168.1.24

ENV PORT_DB=3307

ENTRYPOINT java -jar buscador.jar
 
