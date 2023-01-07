# BUILD
FROM maven:3.8.3-openjdk-17 as build

WORKDIR /usr/src/mymaven

COPY pom.xml .
RUN mvn verify -DskipTests --fail-never

COPY src ./src
RUN mvn verify

# RUN
FROM eclipse-temurin:17-jre

ENTRYPOINT ["java", "-jar", "/app/register-flow-api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

WORKDIR /app
COPY --from=build /usr/src/mymaven/target .
