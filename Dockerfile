FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY . /app
RUN mvn clean package


FROM openjdk:17-jre-alpine
WORKDIR /app
COPY --from=0 /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]s