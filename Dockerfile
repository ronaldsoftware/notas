FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/notas-0.0.1-SNAPSHOT.jar /app/notas.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/notas.jar"]
