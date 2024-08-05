FROM openjdk:21
WORKDIR /app
COPY ./target/user-service-0.0.1-SNAPSHOT.jar /app
EXPOSE 8765
CMD ["java", "-jar", "user-service-0.0.1-SNAPSHOT.jar"]