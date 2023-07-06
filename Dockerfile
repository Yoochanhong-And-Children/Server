FROM eclipse-temurin:17-jre-focal

COPY build/libs/*.jar server.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/server.jar"]
