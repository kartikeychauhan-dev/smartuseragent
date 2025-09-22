FROM eclipse-temurin:21-jdk-jammy as deps
WORKDIR /app
COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/
Copy target/
EXPOSE 8080

ENTRYPOINT ["java","-jar", "-b"]