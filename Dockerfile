FROM openjdk:17-jdk
VOLUME /tmp
ARG JAR_FILE=/target/aerztekasse-api-2025-03-30-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
