FROM openjdk:17

WORKDIR /app

COPY target/participant.jar app.jar

EXPOSE 8089

ENTRYPOINT ["java", "-jar", "app.jar"]
