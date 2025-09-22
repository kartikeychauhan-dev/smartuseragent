FROM eclipse-temurin:21-jdk-jammy as deps
WORKDIR /app
COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/
Copy target/smartgroupassignai-0.0.1.jar /app/smartgroupassignai-0.0.1.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar", "smartgroupassignai-0.0.1.jar"]