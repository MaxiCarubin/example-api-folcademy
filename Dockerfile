FROM openjdk:11-jre-slim

WORKDIR /app

COPY ./target/myapp.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]