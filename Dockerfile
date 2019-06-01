FROM 8u212-jdk-slim

EXPOSE 8080

COPY ./target/countrycode-0.0.1-SNAPSHOT.jar webapp.jar

CMD ["java", "-jar", "webapp.jar"]