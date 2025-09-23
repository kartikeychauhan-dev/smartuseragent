FROM eclipse-temurin:21-jdk

Copy target/smartgroupassignai-0.0.1.jar /app/smartgroupassignai-0.0.1.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar", "smartgroupassignai-0.0.1.jar"]